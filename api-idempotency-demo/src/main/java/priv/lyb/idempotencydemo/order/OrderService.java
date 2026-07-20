package priv.lyb.idempotencydemo.order;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import priv.lyb.idempotencydemo.idempotency.IdempotencyRecord;
import priv.lyb.idempotencydemo.idempotency.IdempotencyStatus;
import priv.lyb.idempotencydemo.idempotency.InMemoryIdempotencyStore;

import java.util.Optional;

/**
 * 订单创建与幂等控制入口。内存记录快速拦截同实例重试，数据库唯一索引兜底跨实例竞争。
 */
@Service
public class OrderService {
    /** 幂等键最大长度，避免超长请求头扩大缓存键和数据库字段的资源消耗。 */
    private static final int MAX_KEY_LENGTH = 64;
    /** 订单仓储：负责订单读取、创建及数据库唯一索引兜底。 */
    private final OrderRepository orderRepository;
    /** 内存幂等存储：教学版模拟 Redis 的原子占位和成功结果缓存。 */
    private final InMemoryIdempotencyStore idempotencyStore;

    public OrderService(OrderRepository orderRepository, InMemoryIdempotencyStore idempotencyStore) {
        this.orderRepository = orderRepository;
        this.idempotencyStore = idempotencyStore;
    }

    /**
     * 创建或复用订单。
     *
     * @param request 已完成参数校验的下单请求体
     * @param idempotencyKey HTTP 请求头 {@code Idempotency-Key} 的原始值
     * @param demoDelayMillis 演示用处理延迟，最大三秒；用于制造同键并发请求的处理中状态
     * @return 首次创建或历史订单对应的响应，以及本次是否为重放请求
     */
    public CreateResult createOrder(CreateOrderRequest request, String idempotencyKey, long demoDelayMillis) {
        String requestId = normalizeKey(idempotencyKey);
        String storeKey = "order:" + request.getUserId() + ":" + requestId;
        if (!idempotencyStore.tryStart(storeKey)) {
            IdempotencyRecord record = idempotencyStore.get(storeKey);
            if (record != null && record.getStatus() == IdempotencyStatus.SUCCESS) {
                return new CreateResult((OrderResponse) record.getResponse(), true);
            }
            throw new IdempotencyInProgressException();
        }
        try {
            delayForDemo(demoDelayMillis);
            // 缓存失效或应用重启后，先从数据库恢复既有订单。
            Optional<Order> existing = orderRepository.findByUserIdAndRequestId(request.getUserId(), requestId);
            if (existing.isPresent()) {
                return cacheAndReturn(storeKey, existing.get(), true);
            }
            Order created = orderRepository.saveAndFlush(new Order(request.getUserId(), requestId,
                    request.getProductName(), request.getQuantity()));
            return cacheAndReturn(storeKey, created, false);
        } catch (DataIntegrityViolationException exception) {
            // 多实例竞争都通过本地占位时，唯一索引拒绝失败方；再查询胜者创建的订单。
            Optional<Order> existing = orderRepository.findByUserIdAndRequestId(request.getUserId(), requestId);
            if (existing.isPresent()) {
                return cacheAndReturn(storeKey, existing.get(), true);
            }
            idempotencyStore.remove(storeKey);
            throw exception;
        } catch (RuntimeException exception) {
            idempotencyStore.remove(storeKey);
            throw exception;
        }
    }

    private CreateResult cacheAndReturn(String storeKey, Order order, boolean replayed) {
        OrderResponse response = OrderResponse.from(order);
        idempotencyStore.markSuccess(storeKey, response);
        return new CreateResult(response, replayed);
    }

    private String normalizeKey(String key) {
        if (key == null || key.trim().isEmpty()) {
            throw new InvalidIdempotencyKeyException("请求头 Idempotency-Key 不能为空");
        }
        String normalized = key.trim();
        if (normalized.length() > MAX_KEY_LENGTH) {
            throw new InvalidIdempotencyKeyException("请求头 Idempotency-Key 长度不能超过 64 个字符");
        }
        return normalized;
    }

    private void delayForDemo(long millis) {
        if (millis <= 0) return;
        try {
            Thread.sleep(Math.min(millis, 3000));
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("订单处理线程被中断", exception);
        }
    }

    /** 控制器据此选择首次 201 或重放 200，并设置重放标记响应头。 */
    public static class CreateResult {
        /** 应返回给客户端的订单响应。 */
        private final OrderResponse response;
        /** 是否命中同键成功记录，控制器据此返回 200 或 201。 */
        private final boolean replayed;
        public CreateResult(OrderResponse response, boolean replayed) { this.response = response; this.replayed = replayed; }
        public OrderResponse getResponse() { return response; }
        public boolean isReplayed() { return replayed; }
    }
}

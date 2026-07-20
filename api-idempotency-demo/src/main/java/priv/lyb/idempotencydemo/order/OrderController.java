package priv.lyb.idempotencydemo.order;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * HTTP 下单接口控制器。
 *
 * <p>接口名称：{@code POST /api/orders}。它负责读取请求头中的幂等键，调用订单服务，
 * 并以 HTTP 201、200、400、409 等状态码展示不同幂等状态。</p>
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    /** 订单服务：封装幂等状态机和数据库唯一索引兜底逻辑。 */
    private final OrderService orderService;
    public OrderController(OrderService orderService) { this.orderService = orderService; }

    /**
     * 创建订单接口。
     *
     * @param request 请求体，包含用户标识、商品名称和购买数量
     * @param idempotencyKey {@code Idempotency-Key} 请求头；同一用户使用相同键重试时必须返回首次结果
     * @param demoDelayMillis {@code X-Demo-Processing-Delay-Millis} 可选请求头；仅用于人为延长处理时间以演示 409，生产接口不应开放
     * @return 首次创建返回 201；同键重放返回 200，且响应头 {@code Idempotency-Replayed} 为 {@code true}
     */
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @Valid @RequestBody CreateOrderRequest request,
            @RequestHeader("Idempotency-Key") String idempotencyKey,
            @RequestHeader(value = "X-Demo-Processing-Delay-Millis", required = false) Long demoDelayMillis) {
        OrderService.CreateResult result = orderService.createOrder(request, idempotencyKey,
                demoDelayMillis == null ? 0L : demoDelayMillis);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Idempotency-Replayed", String.valueOf(result.isReplayed()));
        return new ResponseEntity<>(result.getResponse(), headers,
                result.isReplayed() ? HttpStatus.OK : HttpStatus.CREATED);
    }
}

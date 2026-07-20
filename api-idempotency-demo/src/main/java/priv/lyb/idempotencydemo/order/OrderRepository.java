package priv.lyb.idempotencydemo.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 订单数据访问接口。
 *
 * <p>按用户 ID 和请求键查询已存在订单，以便在数据库唯一索引拦截重复写入后返回首个订单结果。
 * 该唯一索引是 Redis 之外的最终幂等保障，不能只依赖 Redis。</p>
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * 在用户所属的业务范围内查询指定请求键对应的订单。
     *
     * @param userId 用户 ID，用于限定请求键的业务范围
     * @param requestId 客户端提交的幂等请求键
     * @return 已创建的订单；不存在时为空
     */
    Optional<Order> findByUserIdAndRequestId(Long userId, String requestId);
}

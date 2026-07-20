package priv.lyb.idempotencydemo.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 订单持久化实体。
 *
 * <p>用户 ID 与请求键共同限定幂等请求的业务范围，避免不同用户碰巧使用相同请求键时互相影响。</p>
 * <p>数据库唯一索引是幂等性的最终兜底：即使 Redis 状态丢失、过期或出现并发竞争，仍可阻止重复订单落库，
 * 因此不能只依赖 Redis。</p>
 */
@Entity
@Table(name = "orders", uniqueConstraints = @UniqueConstraint(
        name = "uk_orders_user_request", columnNames = {"user_id", "request_id"}))
public class Order {

    /** 数据库生成的订单主键。 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 用户 ID 是请求键所属业务范围的一部分。 */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /** 客户端提交的幂等请求键，与用户 ID 组合后必须唯一。 */
    @Column(name = "request_id", nullable = false, length = 64)
    private String requestId;

    /** 下单商品名称。 */
    @Column(name = "product_name", nullable = false)
    private String productName;

    /** 下单商品数量。 */
    @Column(nullable = false)
    private Integer quantity;

    /** JPA 通过反射创建实体时需要无参构造器。 */
    protected Order() {
    }

    /** 教学示例创建订单时使用的全参构造器。 */
    public Order(Long userId, String requestId, String productName, Integer quantity) {
        this.userId = userId;
        this.requestId = requestId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

package priv.lyb.idempotencydemo.order;

/**
 * 创建订单接口的稳定响应；首次成功对象会被缓存，重复请求可直接复用。
 */
public class OrderResponse {
    /** 响应字段 {@code id}：数据库生成的订单主键。 */
    private final Long id;
    /** 响应字段 {@code userId}：创建订单的用户 ID。 */
    private final Long userId;
    /** 响应字段 {@code requestId}：规范化后的幂等请求键。 */
    private final String requestId;
    /** 响应字段 {@code productName}：订单商品名称。 */
    private final String productName;
    /** 响应字段 {@code quantity}：订单购买数量。 */
    private final Integer quantity;

    public OrderResponse(Long id, Long userId, String requestId, String productName, Integer quantity) {
        this.id = id;
        this.userId = userId;
        this.requestId = requestId;
        this.productName = productName;
        this.quantity = quantity;
    }

    /** 将数据库实体转换成不会暴露持久化细节的 API 响应。 */
    public static OrderResponse from(Order order) {
        return new OrderResponse(order.getId(), order.getUserId(), order.getRequestId(),
                order.getProductName(), order.getQuantity());
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getRequestId() { return requestId; }
    public String getProductName() { return productName; }
    public Integer getQuantity() { return quantity; }
}

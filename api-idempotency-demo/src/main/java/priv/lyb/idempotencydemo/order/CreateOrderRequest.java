package priv.lyb.idempotencydemo.order;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * {@code POST /api/orders} 的请求体。
 *
 * <p>幂等键不放在请求体中，而是从 HTTP 的 {@code Idempotency-Key} 请求头读取；这样业务参数与重试控制参数职责分离。</p>
 */
public class CreateOrderRequest {
    /** 请求参数 {@code userId}：下单用户 ID，也是幂等键的业务作用域。 */
    @NotNull(message = "userId 不能为空")
    private Long userId;
    /** 请求参数 {@code productName}：本次订单购买的商品名称。 */
    @NotBlank(message = "productName 不能为空")
    private String productName;
    /** 请求参数 {@code quantity}：购买数量，必须至少为 1。 */
    @NotNull(message = "quantity 不能为空")
    @Min(value = 1, message = "quantity 必须大于等于 1")
    private Integer quantity;

    /** @return 请求参数 {@code userId} 的值。 */
    public Long getUserId() { return userId; }
    /** @param userId 请求参数 {@code userId} 的反序列化赋值。 */
    public void setUserId(Long userId) { this.userId = userId; }
    /** @return 请求参数 {@code productName} 的值。 */
    public String getProductName() { return productName; }
    /** @param productName 请求参数 {@code productName} 的反序列化赋值。 */
    public void setProductName(String productName) { this.productName = productName; }
    /** @return 请求参数 {@code quantity} 的值。 */
    public Integer getQuantity() { return quantity; }
    /** @param quantity 请求参数 {@code quantity} 的反序列化赋值。 */
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}

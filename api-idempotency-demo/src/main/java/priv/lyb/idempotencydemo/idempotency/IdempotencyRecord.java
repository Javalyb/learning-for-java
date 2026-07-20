package priv.lyb.idempotencydemo.idempotency;

/**
 * 单个幂等键对应的状态及首次成功响应。
 */
public class IdempotencyRecord {

    /** 当前幂等状态：处理中或已成功。 */
    private final IdempotencyStatus status;
    /** 首次成功时缓存的响应；处理中状态固定为 {@code null}。 */
    private final Object response;

    private IdempotencyRecord(IdempotencyStatus status, Object response) {
        this.status = status;
        this.response = response;
    }

    public static IdempotencyRecord processing() {
        return new IdempotencyRecord(IdempotencyStatus.PROCESSING, null);
    }

    public static IdempotencyRecord success(Object response) {
        return new IdempotencyRecord(IdempotencyStatus.SUCCESS, response);
    }

    public IdempotencyStatus getStatus() {
        return status;
    }

    public Object getResponse() {
        return response;
    }
}

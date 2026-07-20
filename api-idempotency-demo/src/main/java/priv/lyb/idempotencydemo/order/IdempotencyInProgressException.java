package priv.lyb.idempotencydemo.order;

/** 同一幂等键已被另一请求占用时抛出，映射为 HTTP 409。 */
public class IdempotencyInProgressException extends RuntimeException {
    public IdempotencyInProgressException() { super("相同幂等键的请求正在处理中，请稍后重试"); }
}

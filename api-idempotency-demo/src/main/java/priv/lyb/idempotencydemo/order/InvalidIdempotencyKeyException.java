package priv.lyb.idempotencydemo.order;

/** 幂等键为空或超长时抛出，映射为 HTTP 400。 */
public class InvalidIdempotencyKeyException extends RuntimeException {
    public InvalidIdempotencyKeyException(String message) { super(message); }
}

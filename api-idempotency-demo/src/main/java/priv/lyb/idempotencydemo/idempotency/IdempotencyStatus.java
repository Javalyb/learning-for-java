package priv.lyb.idempotencydemo.idempotency;

/**
 * 幂等请求在服务端的处理状态。
 */
public enum IdempotencyStatus {

    /** 请求已原子占位，业务处理尚未完成。 */
    PROCESSING,

    /** 请求已成功完成，可复用首次响应。 */
    SUCCESS
}

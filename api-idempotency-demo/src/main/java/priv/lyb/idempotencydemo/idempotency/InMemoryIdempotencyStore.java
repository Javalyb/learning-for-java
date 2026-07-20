package priv.lyb.idempotencydemo.idempotency;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 用于教学演示的内存幂等记录存储。
 *
 * <p>生产环境应使用 Redis 的 {@code SET key value NX EX seconds} 完成原子占位并设置过期时间。
 * {@link ConcurrentMap#putIfAbsent(Object, Object)} 在本演示中承担 {@code NX} 的作用。</p>
 *
 * <p>此实现没有 TTL：进程存活期间未移除的记录会一直保留，既不能跨实例共享，也无法自动恢复超时的
 * PROCESSING 状态，因此不能直接用于生产环境。</p>
 */
@Component
public class InMemoryIdempotencyStore {

    /** 幂等键到状态记录的映射；并发 Map 保证同一 JVM 内原子占位。 */
    private final ConcurrentMap<String, IdempotencyRecord> records = new ConcurrentHashMap<>();

    /**
     * 原子尝试为请求键创建处理中记录。
     *
     * @param key 幂等键
     * @return 首次占位返回 {@code true}；键已存在返回 {@code false}
     */
    public boolean tryStart(String key) {
        return records.putIfAbsent(key, IdempotencyRecord.processing()) == null;
    }

    public IdempotencyRecord get(String key) {
        return records.get(key);
    }

    /**
     * 保存首次成功响应。后续任务中的 {@code OrderResponse} 可直接作为该参数传入。
     *
     * @param key 幂等键
     * @param response 首次成功响应
     */
    public void markSuccess(String key, Object response) {
        records.put(key, IdempotencyRecord.success(response));
    }

    /**
     * 释放失败或可重试请求的占位记录。
     *
     * @param key 幂等键
     */
    public void remove(String key) {
        records.remove(key);
    }
}

package priv.lyb.sca.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;

/**
 * Sentinel 统一 BlockHandler / Fallback 处理类.
 *
 * 注意：
 * - blockHandler: 处理 BlockException（限流/降级触发）—— 参数必须与原方法一致且末尾加 BlockException
 * - fallback:    处理业务异常（原方法抛出异常时）—— 参数必须与原方法一致且末尾加 Throwable
 *
 * 两个方法签名规则相同但用途不同，不要混用。
 */
public class SentinelBlockHandler {

    // ==================== QPS 流控的 blockHandler ====================

    /**
     * QPS 流控触发时的兜底方法.
     * 当请求 QPS 超过阈值时，Sentinel 抛出 FlowException，由此方法处理.
     */
    public static String handleQpsBlock(String name, BlockException ex) {
        return "[QPS流控触发] 请求被限流！参数: name=" + name + ", 异常: " + ex.getClass().getSimpleName();
    }

    // ==================== 方法流控的 blockHandler ====================

    /**
     * 热点参数限流触发时的兜底方法.
     * 当某个热点参数的 QPS 超过阈值时触发.
     */
    public static String handleHotParamBlock(String userId, BlockException ex) {
        return "[热点参数限流触发] userId=" + userId + " 的请求过于频繁，请稍后重试！";
    }

    /**
     * 链路/方法级别限流的兜底方法.
     */
    public static String handleMethodBlock(BlockException ex) {
        return "[方法限流触发] 该方法调用频率过高，已被限流！异常: " + ex.getClass().getSimpleName();
    }

    // ==================== 熔断降级的 blockHandler / fallback ====================

    /**
     * 熔断降级 blockHandler（DegradeException）.
     * 当熔断规则触发时（慢调用比例/异常比例/异常数），由 BlockException 进入.
     */
    public static String handleDegradeBlock(String param, BlockException ex) {
        String detail = "";
        if (ex instanceof DegradeException) {
            detail = " (熔断已打开，所有请求快速失败)";
        }
        return "[熔断触发" + detail + "] 服务暂时不可用，请稍后重试！参数: " + param;
    }

    /**
     * 业务异常 fallback（业务方法抛出异常时进入）.
     * 注意：这是 fallback 不是 blockHandler，处理的是原方法抛出的业务异常.
     */
    public static String handleBusinessFallback(String param, Throwable t) {
        return "[业务降级] 服务执行异常: " + t.getMessage();
    }
}

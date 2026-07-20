package priv.lyb.sca.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import priv.lyb.sca.sentinel.handler.SentinelBlockHandler;

/**
 * 熔断降级演示.
 *
 * Sentinel 熔断 (Circuit Breaking / Degrade) 策略：
 *
 * 1. 慢调用比例 (Slow Request Ratio)：
 *    - 当响应时间 > RT(最大响应时间) 的请求占比超过阈值时，触发熔断
 *    - 熔断时间窗口内，所有请求快速失败（不调用真实方法）
 *    - 时间窗口过后进入探测恢复状态（半开）
 *
 * 2. 异常比例 (Exception Ratio)：
 *    - 当请求异常比例超过阈值时触发熔断
 *    - 与慢调用比例一样经过"打开 → 半开 → 关闭"的状态机
 *
 * 3. 异常数 (Exception Count)：
 *    - 当一分钟内请求异常数超过设定值时触发熔断
 *    - 适合对异常敏感的接口
 *
 * 熔断状态机：
 *   CLOSED (关闭，正常) → 触发条件 → OPEN (打开，快速失败)
 *   OPEN → 等待探测时间 → HALF-OPEN (半开，放行一个请求测试)
 *   HALF-OPEN 成功 → CLOSED；失败 → OPEN（重新计时）
 *
 * 测试方法：
 *   curl "http://localhost:8085/api/degrade/slow?delay=3000"  （模拟慢调用）
 *   curl "http://localhost:8085/api/degrade/error?fail=true"  （模拟异常）
 *   curl "http://localhost:8085/api/degrade/error?fail=false" （正常调用）
 */
@RestController
@RequestMapping("/api/degrade")
public class DegradeController {

    /**
     * 熔断降级 - 慢调用比例演示.
     *
     * 设定规则示例（Dashboard 或程序化配置）：
     *   - 最大 RT：200ms
     *   - 慢调用比例阈值：50%
     *   - 熔断时长：10s
     *   - 最小请求数：5（统计窗口内至少 5 个请求才生效）
     *
     * 测试：传入 delay=500（模拟耗时 500ms 的慢请求），多次调用超过比例后触发熔断.
     *
     * blockHandler 处理 DegradeException（熔断打开时进入），
     * fallback 处理业务方法内部异常（如 RuntimeException）.
     */
    @SentinelResource(
            value = "degradeSlow",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "handleDegradeBlock",
            fallbackClass = SentinelBlockHandler.class,
            fallback = "handleBusinessFallback"
    )
    @GetMapping("/slow")
    public String slowCallTest(@RequestParam(value = "delay", defaultValue = "100") int delay) {
        // 模拟慢调用：sleep 指定毫秒数
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "慢调用测试通过！耗时: " + delay + "ms";
    }

    /**
     * 熔断降级 - 异常比例演示.
     *
     * 设定规则示例：
     *   - 异常比例阈值：50%
     *   - 熔断时长：10s
     *   - 最小请求数：5
     *
     * 测试：传入 fail=true 多次触发异常，异常比例超过 50% 后熔断打开.
     * 后续即使 fail=false，在熔断时间窗内请求也会被 blockHandler 拦截.
     */
    @SentinelResource(
            value = "degradeError",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "handleDegradeBlock",
            fallbackClass = SentinelBlockHandler.class,
            fallback = "handleBusinessFallback"
    )
    @GetMapping("/error")
    public String errorTest(@RequestParam(value = "fail", defaultValue = "false") boolean fail) {
        if (fail) {
            throw new RuntimeException("模拟业务异常！请连续调用触发熔断规则");
        }
        return "异常比例测试通过！当前请求成功";
    }

    /**
     * 熔断降级 - 异常数演示.
     *
     * 设定规则示例：
     *   - 异常数阈值：3 个/分钟
     *   - 熔断时长：10s
     *
     * 测试：连续请求 fail=true 超过 3 次触发熔断.
     */
    @SentinelResource(
            value = "degradeCount",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "handleDegradeBlock",
            fallbackClass = SentinelBlockHandler.class,
            fallback = "handleBusinessFallback"
    )
    @GetMapping("/count")
    public String countTest(@RequestParam(value = "fail", defaultValue = "false") boolean fail) {
        if (fail) {
            throw new RuntimeException("模拟异常，触发异常数熔断！");
        }
        return "异常数测试通过！当前请求成功（连续异常超过阈值会触发熔断）";
    }
}

package priv.lyb.sca.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import priv.lyb.sca.sentinel.handler.SentinelBlockHandler;

/**
 * QPS 流控演示.
 *
 * Sentinel 流控 (Flow Control) 规则类型：
 * - QPS 模式：限制每秒请求数，超出直接拒绝
 * - 线程数模式：限制并发线程数
 * - 流控效果：快速失败（默认）、Warm Up（预热）、排队等待
 *
 * 测试方法（快速连续刷新请求）：
 *   curl http://localhost:8085/api/qps/test?name=alice
 *
 * 程序化规则：本资源 "qpsTest" 的 QPS 阈值为 2，超出后触发 blockHandler.
 */
@RestController
@RequestMapping("/api/qps")
public class QpsLimitController {

    /**
     * QPS 限流示例接口.
     *
     * @SentinelResource 属性说明：
     *   value        - 资源名称（Sentinel 以此名称识别资源，在 Dashboard 中可见）
     *   blockHandler - 限流/降级触发时调用的方法名（必须是静态方法，参数与当前方法一致 + BlockException）
     */
    @SentinelResource(
            value = "qpsTest",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "handleQpsBlock"
    )
    @GetMapping("/test")
    public String qpsTest(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "QPS限流测试通过！收到请求: name=" + name;
    }
}

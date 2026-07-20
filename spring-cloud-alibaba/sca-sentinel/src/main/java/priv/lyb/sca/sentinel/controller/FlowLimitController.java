package priv.lyb.sca.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.lyb.sca.sentinel.handler.SentinelBlockHandler;

/**
 * 方法/热点参数限流演示.
 *
 * Sentinel 支持更细粒度的流控策略：
 *
 * 1. 热点参数限流 (Hot Param Flow Control)：
 *    - 对某个参数值（如 userId）单独限流，同一接口不同 userId 的 QPS 限制可以不同
 *    - 例如：userId=1 限制 QPS 5，userId=2 限制 QPS 10
 *
 * 2. 链路限流 (Link Flow Control)：
 *    - 记录资源的调用链路入口，仅对从指定入口进入的调用做限流
 *    - 例如：/api/method/serviceA 只限制从 /gateway 入口进来的流量
 *
 * 3. 关联限流 (Relate Flow Control)：
 *    - 当关联资源达到阈值时，限流当前资源
 *    - 例如：当写操作 /write 的 QPS 过高，就限流读操作 /read
 *
 * 测试方法：
 *   热点参数限流 → curl http://localhost:8085/api/method/hot/user123
 *   链路限流     → curl http://localhost:8085/api/method/serviceA
 *   关联限流     → curl http://localhost:8085/api/method/read  （写操作频繁时观察）
 */
@RestController
@RequestMapping("/api/method")
public class FlowLimitController {

    /**
     * 热点参数限流示例.
     *
     * 给不同的 userId 设置不同的 QPS 阈值（通过 Dashboard 或程序化规则配置）.
     * 当传入的 userId 频繁访问时，对该 userId 的请求触发限流.
     */
    @SentinelResource(
            value = "hotParamTest",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "handleHotParamBlock"
    )
    @GetMapping("/hot/{userId}")
    public String hotParamTest(@PathVariable String userId) {
        return "热点参数限流测试通过！userId=" + userId + " 的请求被正常处理";
    }

    /**
     * 链路/方法限流示例.
     *
     * 限制该方法的直接调用频率（入口流量控制）.
     * 在 Sentinel Dashboard 中可以配置该资源的入口链路规则.
     */
    @SentinelResource(
            value = "methodLimit",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "handleMethodBlock"
    )
    @GetMapping("/serviceA")
    public String methodLimitTest() {
        return "方法限流测试通过！serviceA 正常响应";
    }

    /**
     * 关联限流示例 —— 读接口.
     *
     * 场景：当写接口 QPS 过高时，自动对读接口进行限流，保护数据库.
     * 关联关系需通过 Dashboard 或程序化规则配置.
     */
    @GetMapping("/read")
    public String readResource() {
        return "读操作完成（当写接口繁忙时此接口可能被限流）";
    }

    /**
     * 关联限流示例 —— 写接口.
     *
     * 高频调用此接口会导致 /read 被限流（依赖关联规则配置）.
     */
    @GetMapping("/write")
    public String writeResource() {
        return "写操作完成（高并发下将关联限流 /read 接口）";
    }
}

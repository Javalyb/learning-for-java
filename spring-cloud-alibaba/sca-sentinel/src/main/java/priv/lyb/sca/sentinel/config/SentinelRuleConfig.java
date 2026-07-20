package priv.lyb.sca.sentinel.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.CircuitBreakerStrategy;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 程序化 Sentinel 规则初始化.
 *
 * 启动时自动将流控/熔断规则加载到 Sentinel 中，无需依赖 Dashboard 即可测试.
 * 如果同时启动了 Dashboard，Dashboard 中的配置将覆盖程序化规则.
 */
@Component
public class SentinelRuleConfig implements CommandLineRunner {

    @Override
    public void run(String... args) {
        initFlowRules();
        initHotParamRules();
        initDegradeRules();
        System.out.println("===== Sentinel 规则初始化完成 =====");
        System.out.println("流控规则: " + FlowRuleManager.getRules().size() + " 条");
        System.out.println("热点规则: " + ParamFlowRuleManager.getRules().size() + " 条");
        System.out.println("降级规则: " + DegradeRuleManager.getRules().size() + " 条");
    }

    /**
     * 初始化 QPS 流控规则.
     *
     * QPS 流控：限制每秒内对该资源的调用次数，超出则触发 blockHandler.
     * 效果：快速失败 — 立即抛出 FlowException.
     */
    private void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();

        // 规则1: qpsTest 资源 — QPS 阈值为 2
        FlowRule qpsRule = new FlowRule("qpsTest");
        qpsRule.setGrade(RuleConstant.FLOW_GRADE_QPS);   // QPS 限流模式
        qpsRule.setCount(2);                              // 每秒最多 2 次请求
        qpsRule.setLimitApp("default");                   // 针对所有来源
        rules.add(qpsRule);

        // 规则2: methodLimit 资源 — QPS 阈值为 3
        FlowRule methodRule = new FlowRule("methodLimit");
        methodRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        methodRule.setCount(3);                           // 每秒最多 3 次请求
        rules.add(methodRule);

        FlowRuleManager.loadRules(rules);
    }

    /**
     * 初始化热点参数限流规则.
     *
     * 热点参数限流：对方法参数做精细化控制，不同参数值可以有不同的 QPS 限制.
     * 例如：userId=admin 放行 QPS 100，userId=guest 限制 QPS 5.
     */
    private void initHotParamRules() {
        ParamFlowRule rule = new ParamFlowRule("hotParamTest")
                .setParamIdx(0)                                 // 对第 0 个参数（userId）做热点控制
                .setGrade(RuleConstant.FLOW_GRADE_QPS)
                .setCount(3);                                   // 默认 QPS 限流 3

        // 特殊参数值：userId=admin 时放宽限制到 QPS 100
        ParamFlowItem adminItem = new ParamFlowItem()
                .setObject("admin")
                .setClassType(String.class.getName())
                .setCount(100);
        rule.setParamFlowItemList(Arrays.asList(adminItem));

        ParamFlowRuleManager.loadRules(Arrays.asList(rule));
    }

    /**
     * 初始化熔断降级规则.
     *
     * 熔断策略：
     *   - 慢调用比例：统计窗口内，慢调用占比过高 → 熔断
     *   - 异常比例：统计窗口内，异常占比过高 → 熔断
     *   - 异常数：统计窗口内，异常次数过多 → 熔断
     *
     * 熔断后进入 OPEN 状态，所有请求直接失败（触发 blockHandler）。
     * 等待熔断时长后进入 HALF-OPEN 状态，放行一个探测请求：
     *   - 成功 → 恢复到 CLOSED 状态
     *   - 失败 → 回到 OPEN 状态（重新计时）
     */
    private void initDegradeRules() {
        List<DegradeRule> rules = new ArrayList<>();

        // 规则1: degradeSlow 资源 — 慢调用比例熔断
        // 当请求中有 50% 的 RT 超过 200ms 时触发熔断，熔断持续 10s
        DegradeRule slowRule = new DegradeRule("degradeSlow")
                .setGrade(CircuitBreakerStrategy.SLOW_REQUEST_RATIO.getType()) // 慢调用比例策略
                .setCount(200)                        // 最大 RT 阈值 (ms)
                .setSlowRatioThreshold(0.5)           // 慢调用比例阈值 50%
                .setMinRequestAmount(3)               // 统计窗口内最小请求数（避免低流量误触发）
                .setStatIntervalMs(10000)             // 统计窗口 10s
                .setTimeWindow(10);                   // 熔断时长 10s
        rules.add(slowRule);

        // 规则2: degradeError 资源 — 异常比例熔断
        // 当异常比例超过 50% 时触发熔断，熔断持续 10s
        DegradeRule errorRule = new DegradeRule("degradeError")
                .setGrade(CircuitBreakerStrategy.ERROR_RATIO.getType())  // 异常比例策略
                .setCount(0.5)                         // 异常比例阈值 50%（范围 0.0~1.0）
                .setMinRequestAmount(3)
                .setStatIntervalMs(10000)
                .setTimeWindow(10);
        rules.add(errorRule);

        // 规则3: degradeCount 资源 — 异常数熔断
        // 当统计窗口内异常数超过 3 次时触发熔断，熔断持续 10s
        DegradeRule countRule = new DegradeRule("degradeCount")
                .setGrade(CircuitBreakerStrategy.ERROR_COUNT.getType())  // 异常数策略
                .setCount(3)                            // 异常数阈值
                .setMinRequestAmount(1)
                .setStatIntervalMs(10000)
                .setTimeWindow(10);
        rules.add(countRule);

        DegradeRuleManager.loadRules(rules);
    }
}

package priv.lyb.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 延迟消息生产者 —— 消息发送后延迟一段时间才被消费
 *
 * 预设延迟级别: 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
 * 对应 level:    1   2   3   4   5  6  7  8  9  10 11 12 13 14  15  16  17 18
 */
@Slf4j
@RestController
public class DelayProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送延迟消息：GET /sendDelay?msg=hello&level=3
     * level 对应上方延迟级别，如 3 = 10s
     */
    @GetMapping("/sendDelay")
    public String sendDelay(String msg, int level) {
        Message<String> message = MessageBuilder.withPayload(msg).build();

        // syncSend(destination, message, timeout, delayLevel)
        rocketMQTemplate.syncSend("delay-topic", message, 3000, level);

        log.info("延迟消息已发送: msg={}, level={}", msg, level);
        return "delay message sent, level=" + level + ", msg=" + msg;
    }
}

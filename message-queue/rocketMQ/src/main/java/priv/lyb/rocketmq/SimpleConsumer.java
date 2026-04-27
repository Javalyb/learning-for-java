package priv.lyb.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 简单消息消费者 —— 订阅 simple-topic 下的所有消息
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = "simple-topic",
        consumerGroup = "${rocketmq.consumer.group}",
        selectorExpression = "*"
)
public class SimpleConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("收到消息: {}", message);
    }
}

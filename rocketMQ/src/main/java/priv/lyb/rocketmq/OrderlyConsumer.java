package priv.lyb.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 顺序消息消费者 —— 消费模式下保证 FIFO
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = "orderly-topic",
        consumerGroup = "${rocketmq.consumer.group}",
        consumeMode = org.apache.rocketmq.spring.annotation.ConsumeMode.ORDERLY
)
public class OrderlyConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("顺序消费收到消息: {}", message);
    }
}

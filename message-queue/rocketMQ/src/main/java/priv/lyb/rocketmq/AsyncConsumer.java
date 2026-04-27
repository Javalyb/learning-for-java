package priv.lyb.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 异步消息消费者
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = "async-topic",
        consumerGroup = "${rocketmq.consumer.group}"
)
public class AsyncConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("收到异步消息: {}", message);
    }
}

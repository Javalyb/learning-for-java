package priv.lyb.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 延迟消息消费者
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = "delay-topic",
        consumerGroup = "${rocketmq.consumer.group}"
)
public class DelayConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("收到延迟消息: {} (时间: {})", message, System.currentTimeMillis());
    }
}

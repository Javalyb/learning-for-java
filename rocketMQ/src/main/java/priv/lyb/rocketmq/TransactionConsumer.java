package priv.lyb.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 事务消息消费者 —— 只有 COMMIT 的事务消息才会被投递过来
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = "tx-topic",
        consumerGroup = "${rocketmq.consumer.group}"
)
public class TransactionConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("收到事务消息(已提交): {}", message);
    }
}

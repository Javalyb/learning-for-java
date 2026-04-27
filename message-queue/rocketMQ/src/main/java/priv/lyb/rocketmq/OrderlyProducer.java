package priv.lyb.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 顺序消息生产者 —— 相同 hashKey 的消息发往同一队列，保证 FIFO 消费
 */
@Slf4j
@RestController
public class OrderlyProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送多条顺序消息：GET /sendOrderly?hashKey=orderId_001
     * 相同 hashKey 的消息会路由到同一个队列，保证顺序消费
     */
    @GetMapping("/sendOrderly")
    public String sendOrderly(String hashKey) {
        for (int i = 0; i < 5; i++) {
            String msg = "消息-" + hashKey + "-序号" + i;
            Message<String> message = MessageBuilder
                    .withPayload(msg)
                    .build();

            // hashKey 用于选择队列，相同 hashKey 进入同一个队列
            rocketMQTemplate.syncSendOrderly("orderly-topic", message, hashKey);
            log.info("顺序消息已发送: {}", msg);
        }
        return "orderly messages sent, hashKey=" + hashKey;
    }
}

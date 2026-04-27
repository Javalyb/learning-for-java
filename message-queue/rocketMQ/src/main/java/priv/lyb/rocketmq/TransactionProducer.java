package priv.lyb.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 事务消息生产者 —— 半消息机制，确保本地事务与消息发送的原子性
 */
@Slf4j
@RestController
public class TransactionProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送事务消息：GET /sendTx?msg=do_order
     */
    @GetMapping("/sendTx")
    public String sendTx(String msg) {
        String txId = UUID.randomUUID().toString().substring(0, 8);
        Message<String> message = MessageBuilder
                .withPayload(msg)
                .setHeader("transactionId", txId)
                .build();

        rocketMQTemplate.sendMessageInTransaction("tx-topic", message, null);
        log.info("事务半消息已发送: txId={}, msg={}", txId, msg);
        return "tx half-message sent, txId=" + txId;
    }
}

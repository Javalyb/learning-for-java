package priv.lyb.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 异步消息生产者
 */
@Slf4j
@RestController
public class AsyncProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送异步消息：GET /asyncSend?msg=hello
     */
    @GetMapping("/asyncSend")
    public String asyncSend(String msg) {
        String key = UUID.randomUUID().toString();
        Message<String> message = MessageBuilder
                .withPayload(msg)
                .setHeader(RocketMQHeaders.KEYS, key)
                .build();

        rocketMQTemplate.asyncSend("async-topic", message,
                new org.apache.rocketmq.client.producer.SendCallback() {
                    @Override
                    public void onSuccess(org.apache.rocketmq.client.producer.SendResult sendResult) {
                        log.info("异步发送成功: key={}, msgId={}", key, sendResult.getMsgId());
                    }

                    @Override
                    public void onException(Throwable e) {
                        log.error("异步发送失败: key={}, error={}", key, e.getMessage());
                    }
                },
                3000 // 超时毫秒
        );

        log.info("异步消息已投递(不等待结果): {}", msg);
        return "async sent: " + msg;
    }

    /**
     * 发送单向消息（不关心结果，性能最高）：GET /oneway?msg=hello
     */
    @GetMapping("/oneway")
    public String oneway(String msg) {
        rocketMQTemplate.sendOneWay("oneway-topic", msg);
        log.info("单向消息已发送(不等待结果): {}", msg);
        return "oneway sent: " + msg;
    }
}

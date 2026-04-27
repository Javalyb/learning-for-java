package priv.lyb.rocketmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单消息生产者，通过 HTTP 接口触发发送
 */
@Slf4j
@RestController
public class SimpleProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送同步消息：GET /send?msg=hello
     */
    @GetMapping("/send")
    public String send(String msg) {
        rocketMQTemplate.convertAndSend("simple-topic", msg);
        log.info("同步消息已发送: {}", msg);
        return "sent: " + msg;
    }

    /**
     * 发送带 Tag 的消息：GET /sendWithTag?tag=order&msg=hello
     */
    @GetMapping("/sendWithTag")
    public String sendWithTag(String tag, String msg) {
        String destination = "simple-topic:" + tag;
        rocketMQTemplate.convertAndSend(destination, msg);
        log.info("带Tag消息已发送 -> topic:simple-topic, tag:{}, msg:{}", tag, msg);
        return "sent: " + msg + " with tag: " + tag;
    }

    /**
     * 发送 JSON 对象消息：GET /sendJson?key=1&val=hello
     */
    @GetMapping("/sendJson")
    public String sendJson(String key, String val) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("val", val);
        String json = new ObjectMapper().writeValueAsString(map);
        rocketMQTemplate.convertAndSend("json-topic", json);
        log.info("JSON消息已发送: {}", json);
        return "sent json: " + json;
    }
}

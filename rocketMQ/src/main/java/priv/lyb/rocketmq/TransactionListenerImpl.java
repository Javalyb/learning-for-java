package priv.lyb.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 事务消息监听器 —— 处理半消息的回查和执行本地事务
 */
@Slf4j
@RocketMQTransactionListener
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {

    private static final ConcurrentHashMap<String, Boolean> TX_STATUS = new ConcurrentHashMap<>();

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        String transactionId = (String) msg.getHeaders().get("transactionId");
        log.info("执行本地事务: transactionId={}, payload={}", transactionId, msg.getPayload());

        try {
            // 模拟执行本地数据库操作等业务逻辑
            TX_STATUS.put(transactionId, true);
            log.info("本地事务执行成功: {}", transactionId);
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            log.error("本地事务执行失败: {}", transactionId, e);
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        String transactionId = (String) msg.getHeaders().get("transactionId");
        Boolean committed = TX_STATUS.get(transactionId);
        log.info("事务回查: transactionId={}, committed={}", transactionId, committed);

        if (committed != null && committed) {
            return RocketMQLocalTransactionState.COMMIT;
        }
        return RocketMQLocalTransactionState.ROLLBACK;
    }
}

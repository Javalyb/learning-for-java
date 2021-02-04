package priv.lyb.study.concurrent.javamultithreadinaction.two;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author LiuYingBo 2021/02/02 19:32
 */
public class RequestIdGenerator {
    private final static short SEQ_UPPER_LIMET = 999;
    private final static RequestIdGenerator INSTANCE = new RequestIdGenerator();
    private short sequence = -1;

    RequestIdGenerator() {
    }

    static RequestIdGenerator getInstance() {
        return INSTANCE;
    }

    short nextSequence() {
        if (sequence > SEQ_UPPER_LIMET) {
            sequence = 0;
        } else {
            sequence++;
        }
        return sequence;
    }

    String nextID() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        DecimalFormat df = new DecimalFormat("000");

        short seqnence = nextSequence();
        return "0049" + timestamp + df.format(seqnence);
    }
}

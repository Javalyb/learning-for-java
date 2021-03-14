package priv.lyb.study.designpattern.creational.factory.simplefactory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author Liuyingbo 2021/1/2
 */
@Slf4j
public class FactoryTest {
    @Test
    public void fun1() {
        Sender senderSms = SenderFactory.getSender("sms");
        Sender senderEmail = SenderFactory.getSender("email");
        senderSms.sender();
        senderEmail.sender();
    }
}

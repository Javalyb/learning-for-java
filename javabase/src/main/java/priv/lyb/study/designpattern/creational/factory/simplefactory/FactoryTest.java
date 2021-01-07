package priv.lyb.study.designpattern.creational.factory.simplefactory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Liuyingbo 2021/1/2
 */
@Slf4j
public class FactoryTest {
    @Test
    public void fun1() {
        SenderFactory senderFactory = new SenderFactory();
        Sender senderSms = senderFactory.getSender("sms");
        Sender senderEamil = senderFactory.getSender("email");
        senderSms.sender();
        senderEamil.sender();
    }
}

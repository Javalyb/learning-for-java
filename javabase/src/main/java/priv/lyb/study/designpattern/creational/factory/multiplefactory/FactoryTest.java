package priv.lyb.study.designpattern.creational.factory.multiplefactory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Liuyingbo 2021/1/2
 */
@Slf4j
public class FactoryTest {
    @Test
    public void fun1() {
        Sender senderSms = SenderFactory.provideSms();
        Sender senderEamil = SenderFactory.provideEmail();
        senderSms.sender();
        senderEamil.sender();
    }
}

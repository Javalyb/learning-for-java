package priv.lyb.designpattern.creational.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Liuyingbo 2021/1/2
 */
@Slf4j
public class FactoryTest {
    @Test
    public void fun1() {
        SenderFactory emailSenderFactory = new EmailProvide();
        emailSenderFactory.provide().sender();
        SenderFactory smsSenderFactory = new SmsProvide();
        smsSenderFactory.provide().sender();
    }
}

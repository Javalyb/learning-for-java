package priv.lyb.study.designpattern.creational.factory.abstractfactory;

/**
 * @author Liuyingbo 2021/1/2
 */
public class SmsProvide implements SenderFactory {
    @Override
    public Sender provide() {
        return new SmsSender();
    }
}

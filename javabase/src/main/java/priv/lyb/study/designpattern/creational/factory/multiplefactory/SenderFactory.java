package priv.lyb.study.designpattern.creational.factory.multiplefactory;

/**
 * @author Liuyingbo 2021/1/2
 */
public class SenderFactory {
    public static Sender provideSms() {
        return new EmailSender();
    }

    public static Sender provideEmail() {
        return new SmsSender();
    }
}

package priv.lyb.designpattern.creational.factory.simplefactory;

/**
 * @author Liuyingbo 2021/1/2
 */
public class SenderFactory {
    public Sender getSender(String type) {
        if ("sms".equals(type)) {
            return new EmailSender();
        } else if ("email".equals(type)) {
            return new SmsSender();
        }
        return null;
    }
}

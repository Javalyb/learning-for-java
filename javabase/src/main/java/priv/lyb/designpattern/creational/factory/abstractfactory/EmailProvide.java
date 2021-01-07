package priv.lyb.designpattern.creational.factory.abstractfactory;

/**
 * @author Liuyingbo 2021/1/2
 */
public class EmailProvide implements SenderFactory {
    @Override
    public Sender provide() {
        return new EmailSender();
    }
}

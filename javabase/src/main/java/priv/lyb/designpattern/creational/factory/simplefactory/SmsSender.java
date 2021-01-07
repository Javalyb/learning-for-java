package priv.lyb.designpattern.creational.factory.simplefactory;

/**
 * @author Liuyingbo 2021/1/2
 */
public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("sms sender");
    }
}

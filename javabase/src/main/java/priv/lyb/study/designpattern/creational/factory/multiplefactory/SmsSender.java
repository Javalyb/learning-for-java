package priv.lyb.study.designpattern.creational.factory.multiplefactory;

/**
 * @author Liuyingbo 2021/1/2
 */
public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("sms sender");
    }
}

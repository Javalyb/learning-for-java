package priv.lyb.study.designpattern.creational.factory.abstractfactory;

/**
 * @author Liuyingbo 2021/1/2
 */
public class EmailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("email sender");
    }
}

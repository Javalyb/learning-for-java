package priv.lyb.study.designpattern.creational.factory.simplefactory;

/**
 * @author Liuyingbo 2021/1/2
 */
public class EmailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("eamil sender");
    }
}

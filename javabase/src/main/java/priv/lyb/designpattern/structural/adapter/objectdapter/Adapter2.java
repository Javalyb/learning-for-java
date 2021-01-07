package priv.lyb.designpattern.structural.adapter.objectdapter;

/**
 * @author LiuYingBo 2021/1/2 下午7:32
 */
public class Adapter2 extends Source implements TargetSource {
    @Override
    public void method2() {
        System.out.println("Adapter2 method2");
    }
}

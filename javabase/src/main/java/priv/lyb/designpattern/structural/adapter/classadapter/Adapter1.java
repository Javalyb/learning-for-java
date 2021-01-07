package priv.lyb.designpattern.structural.adapter.classadapter;

/**
 * @author LiuYingBo 2021/1/2
 */
public class Adapter1 extends Source implements TargetSource {
    @Override
    public void method2() {
        System.out.println("Adapter1 method2");
    }
}

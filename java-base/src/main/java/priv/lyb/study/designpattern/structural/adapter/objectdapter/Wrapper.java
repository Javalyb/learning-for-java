package priv.lyb.study.designpattern.structural.adapter.objectdapter;

/**
 * @author LiuYingBo 2021/1/2 下午7:51
 */
public class Wrapper implements TargetSource {

    private Source source;

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("Wrapper method2");
    }
}

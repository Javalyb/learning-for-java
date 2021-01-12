package priv.lyb.study.designpattern.structural.ornament;

/**
 * @author LiuYingBo 2021/1/2 下午10:18
 */
public class OrnamentClass implements Class1 {
    private Class1 class1;

    public OrnamentClass(Class1 class1) {
        this.class1 = class1;
    }

    @Override
    public void method1() {
        System.out.println("start");
        class1.method1();
        System.out.println("end");
    }
}

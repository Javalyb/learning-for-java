package priv.lyb.study.designpattern.structural.ornament;

/**
 * @author LiuYingBo 2021/1/2 下午10:18
 */
public class OrnamentClass implements priv.lyb.study.designpattern.structural.ornament.Class1 {
    private priv.lyb.study.designpattern.structural.ornament.Class1 class1;

    public OrnamentClass(priv.lyb.study.designpattern.structural.ornament.Class1 class1) {
        this.class1 = class1;
    }

    @Override
    public void method1() {
        System.out.println("start");
        class1.method1();
        System.out.println("end");
    }
}

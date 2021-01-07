package priv.lyb.designpattern.structural.ornament;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/2 下午10:20
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        priv.lyb.designpattern.structural.ornament.Class1 class1 = new priv.lyb.designpattern.structural.ornament.ChildrenClass1();
        priv.lyb.designpattern.structural.ornament.OrnamentClass ornamentClass = new priv.lyb.designpattern.structural.ornament.OrnamentClass(class1);
        ornamentClass.method1();
    }
}

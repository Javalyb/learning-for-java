package priv.lyb.designpattern.structural.ornament;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/2 下午10:20
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        Class1 class1 = new ChildrenClass1();
        OrnamentClass ornamentClass = new OrnamentClass(class1);
        ornamentClass.method1();
    }
}

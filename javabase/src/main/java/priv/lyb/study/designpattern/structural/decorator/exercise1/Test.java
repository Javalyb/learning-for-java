package priv.lyb.study.designpattern.structural.decorator.exercise1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/2 下午10:20
 */
@Slf4j
public class Test {
    @org.junit.jupiter.api.Test
    public void fun() {
        Class1 class1 = new ChildrenClass1();
        OrnamentClass ornamentClass = new OrnamentClass(class1);
        ornamentClass.method1();
    }
}

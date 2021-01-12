package priv.lyb.study.base.statickey.package1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/4 上午3:47
 */

/**
 * 1.静态变量和静态方法先于实例对象创建；
 * 2.静态变量和静态方法属于类和类的所有实例对象，父子类拥有独立的变量和静态变量；
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        A classA = new A();
        classA.method1();
        A.method1();
    }
}

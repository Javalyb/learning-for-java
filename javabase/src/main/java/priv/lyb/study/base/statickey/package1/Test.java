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
    @org.junit.jupiter.api.Test
    public void fun() {
        A classA = new A();
        classA.method1();
        A.method1();
    }

    private int b = 0;
    private final int a = b++;
    @org.junit.jupiter.api.Test
    public void fun1(){
        Test test = null;
        try {
            test = Test.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        for (int i=0;i<5;i++){
            System.out.println(test.a);
        }
    }
}

package priv.lyb.study.base.statickey.package3;

/**
 * @author LiuYingBo 2021/01/12 18:32
 */

/**
 * 执行顺序：
 * 1.按静态变量和静态块先后顺序；
 * 2.按非静态变量和非静态块先后顺序；
 * 3.构造方法；
 */
public class Test {
    @org.junit.Test
    public void fun(){
        A a = new A();
    }
}

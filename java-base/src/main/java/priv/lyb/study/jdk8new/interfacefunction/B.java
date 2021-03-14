package priv.lyb.study.jdk8new.interfacefunction;

/**
 * @author LiuYingBo 2021/01/11 16:21
 */
public class B implements A {
    @Override
    public void fun() {
        A.super.defaultFunA("a");
        A.super.defaultFunB("b");
        A.staticFunA("a");
    }
}

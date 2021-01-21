package priv.lyb.study.base.genericity.thinkingjavafour.util;

import org.junit.Test;

/**
 * @author LiuYingBo 2021/01/13 19:17
 */
public class GenericMethods {
    public <T> void fun(T t) {
        System.out.println(t.getClass());
    }

    public <T, V> void fun(T t, V v) {
        System.out.println(t.getClass());
    }

    public <T> void fun1(T t, T t1) {
        System.out.println("fun1");
    }

    //泛型方法与可变参数列表
    public <T> void fun2(T... t){
        System.out.println(t.length);
    }

    public void fun3(String... a){
        System.out.println(a.length);
    }

    @Test
    public void fun() {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.fun1("a", 1);
        genericMethods.fun(new Double(5));
    }

}

package priv.lyb.study.base.statickey.package2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/4 下午2:07
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        A a = new B();
        a.fun1();
        a.fun2();
        System.out.println();
        System.out.println(a.a);
        System.out.println(a.c);
    }
}

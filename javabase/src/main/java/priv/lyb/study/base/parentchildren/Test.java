package priv.lyb.study.base.parentchildren;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/4 上午1:41
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        A obj1 = new B();
        obj1.a();
        System.out.println(obj1.i);
    }
}

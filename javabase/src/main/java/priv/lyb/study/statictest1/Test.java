package priv.lyb.study.statictest1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/4 下午2:07
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        ClassA classA = new ClassA();
        classA.fun1();
        classA.fun2();
    }
}

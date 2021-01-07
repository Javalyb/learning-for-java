package priv.lyb.study.statictest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/4 上午3:47
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        ClassA classA = new ClassA();
        classA.method1();
        ClassA.method1();
    }
}

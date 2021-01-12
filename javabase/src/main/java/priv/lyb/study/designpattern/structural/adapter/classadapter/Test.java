package priv.lyb.study.designpattern.structural.adapter.classadapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/2 下午7:34
 * 类的适配
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        TargetSource targetSource1 = new Adapter1();
        targetSource1.method1();
        targetSource1.method2();

        TargetSource targetSource2 = new Adapter2();
        targetSource2.method1();
        targetSource2.method2();
    }
}

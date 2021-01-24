package priv.lyb.study.designpattern.structural.adapter.objectdapter;

import lombok.extern.slf4j.Slf4j;


/**
 * @author LiuYingBo 2021/1/2 下午7:34
 * 类的适配
 */
@Slf4j
public class Test {
    @org.junit.jupiter.api.Test
    public void fun() {
        Source source = new Source();
        TargetSource targetSource = new Wrapper(source);
        targetSource.method1();
        targetSource.method2();

        Source source1 = new Source();
        TargetSource targetSource1 = new Wrapper(source1);
        targetSource1.method1();
        targetSource1.method2();
    }
}

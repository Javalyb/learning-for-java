package priv.lyb.designpattern.structural.adapter.interfaceadapter;

import lombok.extern.slf4j.Slf4j;


/**
 * @author LiuYingBo 2021/1/2 下午8:28
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        Source source = new SourceSub1();
        source.method1();
        source.method2();
    }
}

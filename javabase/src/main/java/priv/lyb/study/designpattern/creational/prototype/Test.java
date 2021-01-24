package priv.lyb.study.designpattern.creational.prototype;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Liuyingbo 2021/1/2
 */
@Slf4j
public class Test implements Cloneable {
    @org.junit.jupiter.api.Test
    public void fun() {
        A a = new A();
        a.setA("a");
        a.setB(new B("b"));
        log.info("{} {}", a.getA(), a.getB().getBb());
        A a1 = a;
        a1.setA("a1");
        a1.setB(new B("b1"));
        log.info("{} {}", a.getA(), a.getB().getBb());
        log.info("{} {}", a1.getA(), a1.getB().getBb());
        A a2 = a.clone();
        a2.setA("a2");
        a2.setB(new B("b2"));
        log.info("{} {}", a.getA(), a.getB().getBb());
        log.info("{} {}", a1.getA(), a1.getB().getBb());
        log.info("{} {}", a2.getA(), a2.getB().getBb());

        a.setA("aa");
        a.setB(new B("bb1"));
        log.info("{} {}", a.getA(), a.getB().getBb());
        log.info("{} {}", a1.getA(), a1.getB().getBb());
        log.info("{} {}", a2.getA(), a2.getB().getBb());
    }
}

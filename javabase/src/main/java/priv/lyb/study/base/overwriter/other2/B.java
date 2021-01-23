package priv.lyb.study.base.overwriter.other2;

import org.junit.Test;

/**
 * @author LiuYingBo 2021/01/08 12:52
 */
public class B extends A {
    @Override
    protected void overWriter(Integer p1, StringBuffer p2) {
        System.out.println("B overWriter");
    }

    @Test
    public void fun(){
        A a1 = new B();
        a1.overWriter(1,new StringBuffer());

        A a2 = new A();
        a2.overWriter(1,new StringBuffer());

        B b1 = new B();
        b1.overWriter(1,new StringBuffer());
    }

}

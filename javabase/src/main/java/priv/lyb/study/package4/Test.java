package priv.lyb.study.package4;

import java.math.BigDecimal;

/**
 * @author LiuYingBo 2021/01/08 11:27
 */
public class Test {
    @org.junit.Test
    public void fun() {
        Integer i = 0;
        System.out.println(i instanceof Integer);
        System.out.println(new NullPointerException() instanceof Object);
    }

    @org.junit.Test
    public void fun1() {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a == b);
        System.out.println(c == d);
    }

    @org.junit.Test
    public void fun2() {
        Double a = 100d;
        Double b = 100d;
        Double c = 200d;
        Double d = 200d;
        System.out.println(a == b);
        System.out.println(c == d);

        Double e = 0.001;
        Double f = 0.001;
        System.out.println(e.compareTo(f));
        BigDecimal bigDecimal1 = new BigDecimal(e);
        BigDecimal bigDecimal2 = new BigDecimal(f);
        System.out.println(bigDecimal1.compareTo(bigDecimal2));

        System.out.println(Double.doubleToLongBits(e) == Double.doubleToLongBits(f));


    }
}

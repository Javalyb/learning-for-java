package priv.lyb.study.base.doublekey;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author LiuYingBo 2021/01/12 11:46
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun1() {
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

    @org.junit.Test
    public void fun2() {
        Double d1 = 100d;
        Double d2 = 100d;
        Double d3 = 200d;
        Double d4 = 200d;
        log.info("d1==d2[{}]", d1 == d2);
        log.info("d3==d4[{}]", d3 == d4);
    }

    @org.junit.Test
    public void fun3() {
        Double d1 = 500d;
        Double d2 = 500d;
        Double d3 = 600d;
        Double d4 = 600d;
        log.info("d1==d2[{}]", d1 == d2);
        log.info("d3==d4[{}]", d3 == d4);
        log.info("Double.doubleToLongBits(d1)==Double.doubleToLongBits(d2)[{}]",
                Double.doubleToLongBits(d1) == Double.doubleToLongBits(d2));
    }
}

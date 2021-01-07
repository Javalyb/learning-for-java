package priv.lyb.study.demo1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuyingbo 2020/12/24
 */
@Slf4j
public class Test1 {
    //    private final static Logger LOGGER = LoggerFactory.getLogger(Test1.class);
    @Test
    public void fun1() {
        Integer a1 = 100;
        Integer a2 = 100;
        Integer a3 = 200;
        Integer a4 = 200;
        log.info("a1==a2[{}]", a1 == a2);
        log.info("a3==a4[{}]", a3 == a4);

        int aa1 = 100;
        int aa2 = 100;
        int aa3 = 200;
        int aa4 = 200;
        log.info("aa1==aa2[{}]", aa1 == aa2);
        log.info("aa3==aa4[{}]", aa3 == aa4);
    }

    @Test
    public void fun2() {
        Double d1 = 100d;
        Double d2 = 100d;
        Double d3 = 200d;
        Double d4 = 200d;
        log.info("d1==d2[{}]", d1 == d2);
        log.info("d3==d4[{}]", d3 == d4);
    }

    @Test
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

    @Test
    public void fun4() {
        Character c1 = 'r';
        Character c2 = 'r';
        log.info("c1==c2[{}]", c1 == c2);
    }

    @Test
    public void fun5() {
        log.info("fun5[{}]", Test1.fun6());
    }

    public static String fun6() {
        String a = "1";
        try {
            a = "3";
            return a;
        } catch (Exception e) {

        } finally {
            a = "2";
            return a;
        }
    }

    @Test
    public void fun7() {
        log.info("[{}]", Integer.TYPE);
        log.info("[{}]", Object.class);
    }

    @Test
    public void fun8() {
        log.info("[{}]", Runtime.getRuntime().freeMemory());
    }

    @Test
    public void fun9() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove(2);
        log.info("[{}]", list.toString());
    }

    @Test
    public void fun10() {
        System.out.println(1 << 30);
    }
}

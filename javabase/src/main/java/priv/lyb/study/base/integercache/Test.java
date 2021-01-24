package priv.lyb.study.base.integercache;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Liuyingbo 2020/12/24
 */

@Slf4j
public class Test {
    //    private final static Logger LOGGER = LoggerFactory.getLogger(Test1.class);

    /**
     * Integer缓存：
     * 1.范围：-128 -> 127，在这个范围会用缓存对象；
     * 2.Integer和int比较的是数值；
     */
    @org.junit.jupiter.api.Test
    public void fun1() {
        Integer a1 = 100;
        Integer a2 = 100;
        Integer a3 = 200;
        Integer a4 = 200;
        log.info("a1==a2[{}]", a1 == a2);
        log.info("a3==a4[{}]", a3 == a4);

        Integer aa1 = 100;
        int aa2 = 100;
        int aa3 = 200;
        int aa4 = 200;
        log.info("aa1==aa2[{}]", aa1 == aa2);
        log.info("aa3==aa4[{}]", aa3 == aa4);
    }
}

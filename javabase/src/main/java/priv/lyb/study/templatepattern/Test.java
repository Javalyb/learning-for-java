package priv.lyb.study.templatepattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/4 上午1:01
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        priv.lyb.study.templatepattern.RestaurantTemplate restaurantTemplate1 = new priv.lyb.study.templatepattern.Person1();
        restaurantTemplate1.process();
        log.error("--------------");
        priv.lyb.study.templatepattern.RestaurantTemplate restaurantTemplate2 = new priv.lyb.study.templatepattern.Person2();
        restaurantTemplate2.process();
    }
}

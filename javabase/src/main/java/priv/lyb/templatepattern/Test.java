package priv.lyb.templatepattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/4 上午1:01
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        RestaurantTemplate restaurantTemplate1 = new Person1();
        restaurantTemplate1.process();
        log.error("--------------");
        RestaurantTemplate restaurantTemplate2 = new Person2();
        restaurantTemplate2.process();
    }
}

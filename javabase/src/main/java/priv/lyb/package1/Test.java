package priv.lyb.package1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/3 下午4:40
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        TotalFactory factory = new TotalFatoryTarget();
        factory.createCar().run();
        factory.createEngine().run();
    }
}

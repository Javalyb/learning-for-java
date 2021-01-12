package priv.lyb.study.designpattern.structural.cblibagent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuYingBo 2021/1/3 下午6:34
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        CglibHandler cglibHandler = new CglibHandler();
        Car car = (Car) cglibHandler.getInstance(new Aodi());
        car.engine();
    }
}

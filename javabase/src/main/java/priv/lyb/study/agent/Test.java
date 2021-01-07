package priv.lyb.study.agent;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author LiuYingBo 2021/1/3 下午5:01
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        Car car1 = new Aodi();
        AgentCar agentCar = new AgentCar(car1);
        agentCar.engine();
    }

    @org.junit.Test
    public void fun1() {
        InvocationHandler invocationHandler = new InvocationHandlerTarget(new Aodi());
        Car car = (Car) Proxy.newProxyInstance(Aodi.class.getClassLoader(), Aodi.class.getInterfaces(), invocationHandler);
        car.engine();
    }


}

package priv.lyb.study.designpattern.structural.agent.jdkdynamicagent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author LiuYingBo 2021/1/3 下午6:17
 */
public class InvocationHandlerTarget implements InvocationHandler {
    private Object object;

    public InvocationHandlerTarget(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(object, args);
        System.out.println("after");
        return null;
    }
}

package priv.lyb.study.cblibagent;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author LiuYingBo 2021/1/3 下午6:29
 */
public class CglibHandler implements MethodInterceptor {
    private Object object;

    public Object getInstance(Object object) {
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before..");
        methodProxy.invoke(object, objects);
        System.out.println("after..");
        return null;
    }
}

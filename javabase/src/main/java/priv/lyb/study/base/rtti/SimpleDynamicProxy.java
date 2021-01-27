package priv.lyb.study.base.rtti;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LiuYingBo 2021/01/27 03:48
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() +
                ", method: " + method + ", args: " + args);
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {
    static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("dynamic somethingElse");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        Interface iface = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                realObject.getClass().getInterfaces(), new DynamicProxyHandler(realObject));
        consumer(iface);

    }
}

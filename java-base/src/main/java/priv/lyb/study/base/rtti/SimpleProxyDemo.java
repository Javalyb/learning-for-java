package priv.lyb.study.base.rtti;

import java.text.SimpleDateFormat;

/**
 * @author LiuYingBo 2021/01/27 03:21
 */
interface Interface{
    void doSomething();
    void somethingElse(String arg);
}
class RealObject implements Interface{
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse "+arg);
    }
}

class SimpleProxy implements Interface{
    private Interface anInterface;
    SimpleProxy(Interface anInterface){
        this.anInterface = anInterface;
    }
    @Override
    public void doSomething() {
        System.out.println("proxy doSomething");
        anInterface.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("proxy somethingElse");
        anInterface.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
//        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}

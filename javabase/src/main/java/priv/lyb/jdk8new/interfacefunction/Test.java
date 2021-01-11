package priv.lyb.jdk8new.interfacefunction;

/**
 * @author LiuYingBo 2021/01/11 16:22
 */
public class Test {
    @org.junit.Test
    public void fun(){
        A a = new B();
        a.defaultFunA("a");
        a.defaultFunB("b");
        A.staticFunA("a");
    }

    @org.junit.Test
    public void fun1(){
        B b = new B();
        b.fun();
    }

    @org.junit.Test
    public void fun2(){
        Inf inf = new InfImp();
        System.out.println(inf.add(10, 20));
        System.out.println(inf.mul(10, 20));
        System.out.println(Inf.div(23, 2));
    }
}

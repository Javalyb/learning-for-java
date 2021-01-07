package priv.lyb.statictest1;

/**
 * @author LiuYingBo 2021/1/4 下午2:06
 */
public class ClassA {
    static {
        System.out.println("ClassA static");
    }

    ClassA() {
        System.out.println("构造");
    }

    static void fun1() {
        System.out.println("static fun1");
    }

    void fun2() {
        System.out.println("fun2");
    }
}

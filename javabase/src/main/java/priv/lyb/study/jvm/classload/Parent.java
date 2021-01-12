package priv.lyb.study.jvm.classload;

/**
 * @author LiuYingBo 2021/1/5 下午12:17
 */
public class Parent {
    static int b = method2();

    static {
        System.out.println("(1)");
    }

    int a = method1();

    {
        System.out.println("(2)");
    }

    Parent() {
        System.out.println("(3)");
    }

    static int method2() {
        System.out.println("(5)");
        return 2;
    }

    int method1() {
        System.out.println("(4)");
        return 1;
    }
}

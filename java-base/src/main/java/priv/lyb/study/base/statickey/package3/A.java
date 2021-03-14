package priv.lyb.study.base.statickey.package3;

/**
 * @author LiuYingBo 2021/01/12 18:31
 */
public class A {
    int a = 1;
    int b = fun1();
    static int c = 2;
    static int d = fun2();

    {
        System.out.println("{2}");
    }

    static {
        System.out.println("{3}");
    }

    A() {
        System.out.println("{1}");
    }


    int fun1() {
        System.out.println("{4}");
        return 0;
    }

    static int fun2() {
        System.out.println("{5}");
        return 0;
    }
}

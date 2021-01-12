package priv.lyb.study.base.statickey.package2;

/**
 * @author LiuYingBo 2021/1/4 下午2:06
 */
public class A {
    int a = 1;
    int b = fun1();
    static int c = 2;
    static int d = fun2();

    A() {
        System.out.print("{1}");
    }

    {
        System.out.print("{2}");
    }

    static {
        System.out.print("{3}");
    }

    int fun1() {
        System.out.print("{4}}");
        return 3;
    }

    static int fun2() {
        System.out.print("{5}");
        return 4;
    }
}

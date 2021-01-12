package priv.lyb.study.base.statickey.package2;

/**
 * @author LiuYingBo 2021/1/4 下午2:06
 */
public class B extends A{
    int a = 5;
    int b = fun1();
    static int c = 6;
    static int d = fun2();

    B() {
        System.out.print("{6}");
    }

    {
        System.out.print("{7}");
    }

    static {
        System.out.print("{8}");
    }

    int fun1() {
        System.out.print("{9}");
        return 7;
    }

    static int fun2() {
        System.out.print("{10}");
        return 8;
    }
}

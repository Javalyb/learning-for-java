package priv.lyb.study.base.functionparam;

import java.util.Arrays;

/**
 * @author LiuYingBo 2021/1/5 下午1:46
 */
public class A {
    static void change(int i, String s, Integer its, int[] arrs, B bb) {
        i = i + 1;
        s = s + "word";
        its = its + 1;
        arrs[0] = 11;
        bb.b = 55;
    }

    public static void main(String[] args) {
        int i = 1;
        String s = "hello";
        Integer it = 5;
        int[] arr = {1, 2, 3};
        B b = new B();
        /**
         * 方法参数（实参：实际参数，在方法调用的时候传入的参数）；
         * 1.字符串为final类型，方法传参后，不会改变原来的值；
         * 2.基本类型：传的是数值，不会改变原来的值；
         * 3.引用类型(包括数组)：传的是引用，会改变原来的值；
         */
        change(i, s, it, arr, b  );
        System.out.println("i=" + i);
        System.out.println("s=" + s);
        System.out.println("it=" + it);
        System.out.println("arr=" + Arrays.toString(arr));
        System.out.println("b=" + b.b);


    }


    static class B {
        int b = 5;
    }
}

package priv.lyb.study.functionparam;

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
        change(i, s, it, arr, b);
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

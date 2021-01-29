package priv.lyb.study.base.array;

import java.util.Arrays;
import java.util.Random;

/**
 * @author LiuYingBo 2021/01/28 17:44
 */
public class ArrayCopying {
    private final static int SZ = 15;
    private static Random rand = new Random(47);

    public static void main(String[] args) {
        int[] a1 = new int[SZ];
        Arrays.setAll(a1, s -> rand.nextInt(SZ));
        ArrayShow.show("a1", a1);

        int[] a2 = Arrays.copyOf(a1, SZ / 2);
        ArrayShow.show("a2", a2);

        Integer[] a3 = new Integer[SZ];
        Arrays.setAll(a3, s -> rand.nextInt(SZ));
        ArrayShow.show("a3", a3);


        Integer[] a4 = Arrays.copyOf(a3, 3);
        ArrayShow.show("a4", a4);

        Integer[] a5 = Arrays.copyOf(a3, 5, Integer[].class);
        ArrayShow.show("a5", a5);

        Integer[] a6 = Arrays.copyOfRange(a3, 10, SZ);
        ArrayShow.show("a6", a6);


        char[] a8 = "sdfsdfsdfsdfdsfsdfsd".toCharArray();
        char[] a9 = new char[a8.length];
        ArrayShow.show("a8",a8);
        ArrayShow.show("a9",a9);
        System.arraycopy(a8,9,a9,9,3);
        ArrayShow.show("a8",a8);
        ArrayShow.show("a9",a9);



    }
}

package priv.lyb.study.base.array;

import java.util.Arrays;

/**
 * @author LiuYingBo 2021/01/28 00:16
 */
public class FillingArrays {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        short[] a3 = new short[size];
        int[] a4 = new int[size];
        long[] a5 = new long[size];
        float[] a6 = new float[size];
        double[] a7 = new double[size];
        String[] a8 = new String[size];
        char[] a9 = new char[size];

        Arrays.fill(a1, true);
        ArrayShow.show("boolean", a1);
        Arrays.fill(a2, (byte) 1);
        ArrayShow.show("byte", a2);
        Arrays.fill(a3, (short) 1);
        ArrayShow.show("short", a3);
        Arrays.fill(a4, 1);
        ArrayShow.show("int", a4);
        Arrays.fill(a5, 1);
        ArrayShow.show("long", a5);
        Arrays.fill(a6, 1);
        ArrayShow.show("float", a6);
        Arrays.fill(a7, 1);
        ArrayShow.show("double", a7);
        Arrays.fill(a8, "1");
        ArrayShow.show("String", a8);
        Arrays.fill(a9, (char) 100);
        ArrayShow.show("char", a9);

    }
}

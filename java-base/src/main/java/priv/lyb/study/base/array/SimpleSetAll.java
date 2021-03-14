package priv.lyb.study.base.array;

import java.util.Arrays;

/**
 * @author LiuYingBo 2021/01/28 01:06
 */
class Bob {
    final int id;

    Bob(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bod " + id;
    }
}

public class SimpleSetAll {
    public static final int SZ = 8;
    static int val = 1;
    static char[] chars = "dfsdfsdfsdfsdfsdfsdfsdf".toCharArray();

    static char getChar(int n) {
        return chars[n];
    }

    public static void main(String[] args) {
        int[] ia = new int[SZ];
        long[] la = new long[SZ];
        double[] da = new double[SZ];
        Arrays.setAll(ia, s -> s);
        Arrays.setAll(la, s -> s);
        Arrays.setAll(da, s -> s);
        ArrayShow.show(ia);
        ArrayShow.show(la);
        ArrayShow.show(da);

        Bob[] ba = new Bob[SZ];
        Arrays.setAll(ba, Bob::new);
        ArrayShow.show(ba);

        Character[] ca = new Character[SZ];
        Arrays.setAll(ca, SimpleSetAll::getChar);
        ArrayShow.show(ca);
    }
}

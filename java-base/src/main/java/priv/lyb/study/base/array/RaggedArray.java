package priv.lyb.study.base.array;

import java.util.Arrays;
import java.util.SplittableRandom;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/27 22:13
 */
public class RaggedArray {
    public static void main(String[] args) {
        SplittableRandom rand = new SplittableRandom(47);
        int[][][] a = new int[rand.nextInt(7)][][];
        System.out.println(Arrays.deepToString(a));
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][];
            for (int i1 = 0; i1 < a[i].length; i1++) {
                a[i][i1] = new int[rand.nextInt(5)];
                Arrays.setAll(a[i][i1],aa -> aa++);
            }
        }
        System.out.println("a.length: " + a.length);
        Stream.of(a).forEach(s -> {
            System.out.println(Arrays.deepToString(s));
        });
    }
}

package priv.lyb.study.base.array;

import com.google.common.collect.ObjectArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.SplittableRandom;

/**
 * @author LiuYingBo 2021/01/28 23:57
 */
public class StringSorting {
    private static SplittableRandom random = new SplittableRandom(47);
    public static void main(String[] args) {
        int[] i = new int[10];
        Arrays.setAll(i,s-> random.nextInt(100));
        System.out.println(Arrays.toString(i));


        Object[] o = Arrays.stream(i).boxed().toArray();
        System.out.println(Arrays.toString(o));

        Arrays.sort(i);
        System.out.println(Arrays.toString(i));

        Integer[] b = new Integer[100];
        Arrays.setAll(b,s->random.nextInt(100));
        System.out.println(Arrays.toString(b));
        Arrays.sort(b, Collections.reverseOrder());
        System.out.println(Arrays.toString(b));

    }
}

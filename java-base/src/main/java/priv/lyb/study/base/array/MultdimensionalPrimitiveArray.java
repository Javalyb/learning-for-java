package priv.lyb.study.base.array;

import java.util.Arrays;

/**
 * @author LiuYingBo 2021/01/27 21:33
 */
public class MultdimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(new int[][][]{
                {
                        {11, 22, 33}, {44, 55, 66}
                },
                {
                        {77},{88,99}
                }
        }));
        float[][][][][] b = new float[5][4][3][2][1];
        Arrays.asList(b)
                .forEach(s->{
                    System.out.println(Arrays.deepToString(s));
                });
    }
}

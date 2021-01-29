package priv.lyb.study.base.array;

import java.util.Arrays;

/**
 * @author LiuYingBo 2021/01/27 22:31
 */
public class MultidimensionalObjectArray {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = new BerylliumSphere[][]{
                {
                        new BerylliumSphere(),
                        new BerylliumSphere()
                },
                {
                        new BerylliumSphere(),
                        new BerylliumSphere()
                }
        };
        System.out.println(Arrays.deepToString(spheres));

        BerylliumSphere[][][] spheres1 = new BerylliumSphere[3][2][1];
        System.out.println(Arrays.deepToString(spheres1));
    }
}

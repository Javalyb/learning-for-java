package priv.lyb.study.jdk8new.stream;

import java.util.Arrays;

/**
 * @author LiuYingBo 2021/01/23 18:55
 */
public class ArrayStream {
    public static void main(String[] args) {
        Arrays.stream(new int[]{1, 2, 3})
                .forEach(System.out::println);
    }
}

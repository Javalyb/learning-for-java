package priv.lyb.study.jdk8new.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author LiuYingBo 2021/01/24 02:02
 */
public class RandomInts {
    public static void main(String[] args) {
        int[] rints = new Random(47).ints(0,1000).limit(100).toArray();
        Arrays.stream(rints).forEach(System.out::println);

    }
}

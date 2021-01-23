package priv.lyb.study.jdk8new.stream;

import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/23 15:55
 */
public class Fibonacci {
    public static void main(String[] args) {
        Stream.iterate(5, n -> {
            return n + 1;
        }).limit(5).forEach(System.out::println);
    }
}

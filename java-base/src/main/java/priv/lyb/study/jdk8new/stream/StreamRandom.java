package priv.lyb.study.jdk8new.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/23 20:34
 */
public class StreamRandom {
    public static void main(String[] args) {
        Random random = new Random(47);
        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(i -> IntStream.concat(
                        random.ints(0, 100).limit(i), IntStream.of(-1)))
                .forEach(System.out::println);
    }
}

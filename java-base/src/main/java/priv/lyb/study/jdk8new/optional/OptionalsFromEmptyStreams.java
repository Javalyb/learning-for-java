package priv.lyb.study.jdk8new.optional;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/23 22:37
 */
public class OptionalsFromEmptyStreams {
    public static void main(String[] args) {
        System.out.println(Stream.<String>empty().findFirst());

        System.out.println(Stream.<String>empty().findAny());

        System.out.println(Stream.<String>empty().max(String.CASE_INSENSITIVE_ORDER));

        System.out.println(Stream.<String>empty().min(String.CASE_INSENSITIVE_ORDER));

        System.out.println(Stream.<String>empty().reduce((s1, s2) -> {
            return s1 + s2;
        }));

        System.out.println(IntStream.empty().average());
    }
}

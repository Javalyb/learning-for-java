package priv.lyb.study.jdk8new.optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/24 00:47
 */
public class OptionalFilter {
    static String[] elements = {
            "Foo", "", "Bar", "Baz", "Bingo"
    };

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void testFilter(String descr, Predicate<String> pred) {
        System.out.println("-----------" + descr + "-----------");
        for (int i = 0; i < elements.length; i++) {
            System.out.println(testStream()
                    .skip(i)
                    .findFirst()
                    .filter(pred));
        }
    }

    static void testMap(String descr, Function<String,String> func) {
        System.out.println("-----------" + descr + "-----------");
        for (int i = 0; i < elements.length; i++) {
            System.out.println(testStream()
                    .skip(i)
                    .findFirst()
                    .map(func));
        }
    }

    static void testFlatMap(String descr, Function<String, Optional<String>> func) {
        System.out.println("-----------" + descr + "-----------");
        for (int i = 0; i < elements.length; i++) {
            System.out.println(testStream()
                    .skip(i)
                    .findFirst()
                    .flatMap(func));
        }
    }

    public static void main(String[] args) {
        testFilter("true ", (str) -> true);
        testFilter("false ", (str) -> false);

        testMap("Add brackets", (s) -> s+"");

        testFlatMap("Optional of 1", Optional::of);
        testFlatMap("Optional of 2", (s) -> Optional.of(s));

    }
}

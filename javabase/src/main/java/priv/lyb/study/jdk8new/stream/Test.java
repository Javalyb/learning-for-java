package priv.lyb.study.jdk8new.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LiuYingBo 2021/01/11 23:18
 */
public class Test {
    @org.junit.Test
    public void fun() {
        List<String> list = Arrays.asList("1", "2", "3", "2", "5", "9", "8");
        List<String> list1 = list.stream().filter(p -> Integer.parseInt(p) > 1).collect(Collectors.toList());
        System.out.println(list1.toString());
        System.out.println();

        List<String> list2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list2.toString());
        System.out.println();


        list.sort((o1, o2) -> {
            System.out.println(o1 + "-" + o2);
            return 0;
        });
        System.out.println();

        System.out.println(list.toString());
        System.out.println();

        List<Double> list3 = list.stream().map(p -> Double.parseDouble(p) * 2.9d).collect(Collectors.toList());
        System.out.println(list3.toString());
        System.out.println();

        list.stream().limit(3).forEach(System.out::println);
        System.out.println();

        list.parallelStream().limit(3).sorted().forEach(System.out::println);
        System.out.println();

        String str = list.stream().sorted().collect(Collectors.joining(""));
        System.out.println(str);
    }
}

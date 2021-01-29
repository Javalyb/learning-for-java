package priv.lyb.study.base.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/27 14:41
 */
class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}

public class CollectionComparison {
    static <T> void consumerShowArray(T[] ts) {
        for (T t : ts) {
            System.out.println(t);
        }
    }


    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }

        consumerShowArray(spheres);
        System.out.println(spheres[4] + " - " + spheres[5]);
//        Stream.of(spheres).forEach(System.out::println);
        List<CollectionComparison> list = Stream.generate(CollectionComparison::new)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list.get(4));

        Integer[] integers = {0, 1, 2, 3, 4, 5};
        consumerShowArray(integers);
        System.out.println("---------------------------");

        List<Integer> intList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.stream().forEach(System.out::println);
    }
}

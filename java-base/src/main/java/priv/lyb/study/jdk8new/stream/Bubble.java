package priv.lyb.study.jdk8new.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/23 15:42
 */
public class Bubble {
    private static int count;
    private int i;
    Bubble(int i){
        this.i = i;
    }

    public static Bubble bubbler(){
        return new Bubble(count++);
    }

    @Override
    public String toString() {
        return "Bubble"+i;
    }

    public static void main(String[] args) {
        Stream.generate(Bubble::bubbler)
                .limit(5)
                .forEach(System.out::println);
    }
}

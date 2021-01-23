package priv.lyb.study.jdk8new.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/23 14:40
 */
public class Streamof {
    @Test
    public void fun(){
        Stream.of("1", "2", "3").
                forEach(System.out::println);

        Stream.of(new Object(), new Object(), new Object())
                .forEach(System.out::println);
    }

    @Test
    public void fun1(){
        Map<Integer,Double> map = new HashMap<>();
        map.put(1,4.23423);
        map.put(2,3.1415926);
        map.entrySet().stream()
                    .map(x -> x.getKey() +" "+ x.getValue())
                    .forEach(System.out::println);
    }
}

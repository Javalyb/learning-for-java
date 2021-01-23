package priv.lyb.study.jdk8new.optional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/23 23:03
 */
public class OptionalBasics {
    static void test(Optional<String> optString){
        if(optString.isPresent()){
            System.out.println(optString.get());;
        }else{
            System.out.println("Nothing inside!");
        }
    }

    public static void main(String[] args) {
        test(Stream.of("Epithets").findFirst());
        test(Stream.of("Epithets","24323").findAny());
        test(Stream.<String>empty().findFirst());
    }
}

package priv.lyb.study.jdk8new.optional;

import java.util.Optional;

/**
 * @author LiuYingBo 2021/01/24 00:21
 */
public class CreatingOptionals {
    static void test(String testName, Optional<String> optString) {
        System.out.println("----------" + testName + "----------");
        System.out.println(optString.orElse("Null"));
    }

    public static void main(String[] args) {
        test("Optional.empty ", Optional.empty());
        test("Optional.of ",Optional.of("Howdy"));
        try {
            test("Optional.of param(null)",Optional.of(null));
        }catch (Exception e){
            System.out.println(e);
        }
        test("Optional.ofNullable",Optional.ofNullable("hi"));
        test("Optional.ofNullable",Optional.ofNullable(null));
    }
}

package priv.lyb.study.jdk8new.lambda;

/**
 * @author LiuYingBo 2021/01/11 12:18
 */
@FunctionalInterface
public interface A {
    void funA();
    default void funB(){
        System.out.println("default  funB");
    }
    default void funC(){
        System.out.println("default funC");
    }
}

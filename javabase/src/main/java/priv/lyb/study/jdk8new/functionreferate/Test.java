package priv.lyb.study.jdk8new.functionreferate;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author LiuYingBo 2021/01/11 15:11
 */
public class Test {
    @org.junit.Test
    public void fun(){
        Supplier<A> consumer = A::new;
        System.out.println(consumer.get());
    }

    @org.junit.Test
    public void fun1(){
        Consumer<String> consumer = A::staticFunA;
        consumer.accept("aa");
    }

    @org.junit.Test
    public void fun2(){
        Consumer<String> consumer = new A()::funB;
        consumer.accept("a");
    }
}

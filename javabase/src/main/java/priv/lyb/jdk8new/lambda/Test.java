package priv.lyb.jdk8new.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/11 00:19
 */
public class Test {
    @org.junit.Test
    public void fun(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("----");
            }
        }).start();
        new Thread(() -> System.out.println("---")).start();
    }

    @org.junit.Test
    public void fun1(){
        List<String> list = Arrays.asList("1","2","3");
        list.forEach(item -> {
            System.out.println(item);
        });
    }

    @org.junit.Test
    public void fun3(){
        A a = () -> {
            System.out.println("-");
        };
        a.funA();
        a.funB();
        a.funC();
    }

    @org.junit.Test
    public void fun5(){
        B b = (a) -> {
            System.out.println("-");
            return a + "-2b";
        };
        String s = b.funA("i'm");
        System.out.println(s);
    }
}

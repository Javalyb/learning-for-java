package priv.lyb.jdk8new.functionreferate;

import java.sql.Struct;

/**
 * @author LiuYingBo 2021/01/11 15:09
 */
public class A {
    A(){
        System.out.println("构造方法");
    }

    static void staticFunA(String a){
        System.out.println("static fun");
    }

    void funB(String a){
        System.out.println("new A().funB()");
    }
}

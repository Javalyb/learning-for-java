package priv.lyb.study.base.annotation;

/**
 * @author LiuYingBo 2021/01/15 01:30
 */
public class Test {
    @TestAnnotation(id = 0,description = "annotation Test fun")
    @org.junit.jupiter.api.Test
    public void fun(){
        Test.fun1();
        System.out.println("Test fun");
    }

    @TestAnnotation(id = 1,description = "annotation Test fun2")
    @org.junit.jupiter.api.Test
    public void fun2(){
        System.out.println("Test fun2");
    }

    //@TestAnnotation(id = 2)
    public static void fun1(){
        System.out.println("Test fun1");
    }
}

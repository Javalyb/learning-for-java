package priv.lyb.exercise.package1;

/**
 * @author LiuYingBo 2021/01/22 16:59
 */
public class B extends A{
    void fun2(){
        System.out.println("B fun2");
    }

    public static void main(String[] args) {
        A b = new B();
//        b.fun2();
        b.fun1();
    }
}

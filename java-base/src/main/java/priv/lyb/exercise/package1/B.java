package priv.lyb.exercise.package1;

/**
 * @author LiuYingBo 2021/02/10 22:13
 */
public interface B {
    int i=0;
    int b();
    default void a(){
        System.out.println("1");
    }
    default void a1(){

    }
    static void aa(){

    }
    static void aa1(){

    }
}

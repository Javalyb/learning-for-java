package priv.lyb.study.base.genericity.thinkingjavafour.util;

/**
 * @author LiuYingBo 2021/01/13 20:28
 */
public class Manipulator<T extends Hasf>{
    private T t;
    public void fun(T t){
        System.out.println("Manipulator fun");
        t.fun();
    }
}

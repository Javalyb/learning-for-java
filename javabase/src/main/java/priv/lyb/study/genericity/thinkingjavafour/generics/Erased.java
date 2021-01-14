package priv.lyb.study.genericity.thinkingjavafour.generics;

/**
 * @author LiuYingBo 2021/01/14 11:07
 */
class Build{}
class House extends Build{}

public class Erased<T> {
    private Class<T> t;
    private final int SIZE = 100;
    public Erased(Class<T> t){
        this.t = t;
    }
    public boolean fun1(Object object){
        //object参数是否是t的实例对象；
        return t.isInstance(object);
    }

    public static void main(String[] args) {
        Erased<Build> a = new Erased<Build>(Build.class);
        System.out.println(a.fun1(new Build()));
        System.out.println(a.fun1(new House()));

        Erased<House> b = new Erased<>(House.class);
        System.out.println(b.fun1(new Build()));
    }

}

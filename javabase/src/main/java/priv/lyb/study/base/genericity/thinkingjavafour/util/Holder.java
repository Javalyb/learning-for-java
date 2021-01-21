package priv.lyb.study.base.genericity.thinkingjavafour.util;

/**
 * @author LiuYingBo 2021/01/14 18:37
 */
public class Holder<T> {
    private T t;
    public Holder(T t){
        this.t = t;
    }
    public T getT(){
        return t;
    }

    public void setT(T t){
        this.t = t;
    }

    public static void main(String[] args) {
        Holder<? extends Apple> aa = new Holder<>(new Jonathan());
        System.out.println(aa.getT());

        Holder<? extends Fruit> bb = new Holder<>(new Jonathan());
        System.out.println(bb.getT());

        Holder<? super Orange> cc = new Holder<>(new Jonathan());
        System.out.println(cc.getT());



        Holder<Apple> apple = new Holder<Apple>(new Apple());
        Apple d = apple.getT();
        apple.setT(d);
        Holder<? extends Fruit> fruit = apple;
        System.out.println(fruit.getT());
        //Exception in thread "main" java.lang.ClassCastException:
        Fruit p = (Orange)fruit.getT();




        Holder<Fruit> a = new Holder<Fruit>(new Fruit());
        System.out.println(a.getT());
        a.setT(new Apple());
        System.out.println(a.getT());
    }
}

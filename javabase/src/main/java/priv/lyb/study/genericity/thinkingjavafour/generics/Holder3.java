package priv.lyb.study.genericity.thinkingjavafour.generics;

import com.sun.webkit.dom.AttrImpl;

/**
 * @author LiuYingBo 2021/01/13 15:36
 */
public class Holder3<T> {
    private T t;
    public Holder3(T t){
        this.t = t;
    }
    public void setT(T t){
        this.t = t;
    }
    public T getT(){
        return t;
    }

    public static void main(String[] args) {
        Holder3<Automobile> a = new Holder3<>(new Automobile());
        Automobile b = a.getT();
        System.out.println(b);

        Holder3<Integer> c = new Holder3<>(3);
        Integer d = c.getT();
        System.out.println(d);
    }
}

package priv.lyb.study.base.genericity.thinkingjavafour.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/14 19:51
 */
public class GenericWritng {
    static <T> void writeExact(List<T> list, T t) {
        list.add(t);
    }
    static List<Apple> apple = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();
    static void fun1(){
        writeExact(apple, new Apple());
        writeExact(fruit, new Apple());
    }

    public static void main(String[] args) {
        fun1();
    }
}

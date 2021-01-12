package priv.lyb.study.base.instanceofkey;

/**
 * @author LiuYingBo 2021/01/12 12:06
 */

import java.util.AbstractList;
import java.util.List;

/**
 * instanceof：用来判断一个对象或其继承子对象是否是一个类的实例对象；
 */
public class Test {
    @org.junit.Test
    public void fun() {
        Integer i = 0;
        System.out.println(i instanceof Integer);
        System.out.println(new NullPointerException() instanceof Object);
    }
}

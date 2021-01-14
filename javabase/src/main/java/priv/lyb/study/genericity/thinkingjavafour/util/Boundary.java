package priv.lyb.study.genericity.thinkingjavafour.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/14 21:04
 */

class A{
    public void fun(){

    }
}

class B extends A{
    @Override
    public void fun() {
        super.fun();
    }
}

class C extends B{
    @Override
    public void fun() {
        super.fun();
    }
}

class ListClass<T>{
    private T t;
    public T get(T t){
        return this.t = t;
    }
    public void add(T t){

    }
}

public class Boundary {
    @Test
    public void fun(){
        List<? extends A> a = null;


        /*List<? extends Number> list = null;
        list = new ArrayList<>();
        Number number = list.get(0);
//        list.add()

        List<? super Integer> list1 = null;
        list1.add(new Integer(1));*/
    }
}

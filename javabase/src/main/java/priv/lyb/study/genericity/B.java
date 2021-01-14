package priv.lyb.study.genericity;

import org.junit.Test;

import java.util.List;

/**
 * @author LiuYingBo 2021/01/13 14:28
 */
public class B<E> {
    public void fun(List<? super E> p){
        System.out.println(p);
    }

    @Test
    public void fun1(){
        B<A> b = new B<>();
    }
}

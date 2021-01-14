package priv.lyb.study.genericity;


import org.junit.Test;

/**
 * @author LiuYingBo 2021/1/4 下午7:31
 */
public class A<T, V> {
    public T fun(V v) {
        T t = null;
        System.out.println(v.toString());
        return t;
    }

    static <T> void fun1(T t){
    }

    @Test
    public void fun(){
        String[] a = new String [5];
        String[] b = {};
    }
}

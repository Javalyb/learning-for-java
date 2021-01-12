package priv.lyb.study.genericity;


/**
 * @author LiuYingBo 2021/1/4 下午7:31
 */
public class A<T, V> {
    public T fun(V v) {
        T t = null;
        System.out.println(v.toString());
        return t;
    }
}

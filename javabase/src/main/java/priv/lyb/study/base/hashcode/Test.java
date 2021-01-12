package priv.lyb.study.base.hashcode;

/**
 * @author LiuYingBo 2021/01/12 12:04
 */
public class Test {
    @org.junit.Test
    public void fun1() {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a == b);
        System.out.println(c == d);
    }
}

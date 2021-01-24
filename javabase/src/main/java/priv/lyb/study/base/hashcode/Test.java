package priv.lyb.study.base.hashcode;

/**
 * @author LiuYingBo 2021/01/12 12:04
 */

/**
 * hashCode：根据对象地址换算出来的一个值；
 * 1.hashCode可能会有hash冲突；
 * 2.对象1==对象2时，hashCode一定相等，可用Object中的equals判断对象是否相等；
 * 3.hashCode相等时，对象不一定相等；
 */
public class Test {
    @org.junit.jupiter.api.Test
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

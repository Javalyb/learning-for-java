package priv.lyb.study.base.instanceofkey;

/**
 * @author LiuYingBo 2021/01/12 12:06
 */
public class Test {
    @org.junit.Test
    public void fun() {
        Integer i = 0;
        System.out.println(i instanceof Integer);
        System.out.println(new NullPointerException() instanceof Object);
    }
}

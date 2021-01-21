package priv.lyb.study.base.genericity.thinkingjavafour.util;

/**
 * @author LiuYingBo 2021/01/13 15:45
 */
public class TwoTuple<A, B> {
    public final A a;
    public final B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return this.a +" "+ this.b;
    }

    public static void main(String[] args) {
        System.out.println(new TwoTuple<Integer,String>(1,"a").toString());
    }
}

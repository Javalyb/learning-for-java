package priv.lyb.study.genericity.thinkingjavafour.util;

/**
 * @author LiuYingBo 2021/01/13 15:53
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C c;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public String toString() {
        return super.a + " " + super.b + " " + this.c;
    }
}

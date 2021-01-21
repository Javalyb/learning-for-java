package priv.lyb.study.base.genericity.thinkingjavafour.util;

/**
 * @author LiuYingBo 2021/01/13 15:58
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D d;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        this.d = d;
    }

    @Override
    public String toString() {
        return super.a + " " + super.b + " " + super.c + "" +this.d;
    }
}

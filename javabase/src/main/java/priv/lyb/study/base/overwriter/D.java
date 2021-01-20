package priv.lyb.study.base.overwriter;

/**
 * @author LiuYingBo 2021/01/08 12:57
 */
public class D implements C {
    @Override
    public F fun1(String p1, Integer p2) {
        return new F();
    }
}

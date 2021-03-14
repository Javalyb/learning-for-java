package priv.lyb.study.base.finalkey;

/**
 * @author LiuYingBo 2021/01/20 18:08
 */
public class Composing {
    private static long a =0;
    private final long b = a++;

    Composing() {
        System.out.println("this: " + this + "; b= " +b);
    }

}

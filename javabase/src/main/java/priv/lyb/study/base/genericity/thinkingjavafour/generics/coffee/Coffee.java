package priv.lyb.study.base.genericity.thinkingjavafour.generics.coffee;

/**
 * @author LiuYingBo 2021/01/13 18:08
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }
}

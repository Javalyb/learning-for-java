package priv.lyb.study.base.string;

/**
 * @author LiuYingBo 2021/01/25 23:24
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
        return "InfiniteRecurson " + this;
    }

    public static void main(String[] args) {
        System.out.println(new InfiniteRecursion());
    }
}

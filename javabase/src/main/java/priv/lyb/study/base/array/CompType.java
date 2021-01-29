package priv.lyb.study.base.array;

import java.util.Arrays;
import java.util.SplittableRandom;

/**
 * @author LiuYingBo 2021/01/28 23:32
 */
public class CompType implements Comparable<CompType> {
    private static int count = 1;
    private static SplittableRandom r = new SplittableRandom(47);
    int i;
    int j;

    CompType(int n1, int n2) {
        this.i = n1;
        this.j = n2;
    }

    static CompType get() {
        return new CompType(r.nextInt(100), r.nextInt(100));
    }

    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        Arrays.setAll(a, n -> get());
        ArrayShow.show("a", a);
        Arrays.sort(a);
        ArrayShow.show("a", a);
    }

    @Override
    public String toString() {
        String result = "[i=" + i + ",j=" + j + "]";
        if (++count % 3 == 0) result += "\n";
        return result;
    }

    @Override
    public int compareTo(CompType o) {
        return (i < o.i ? -1 : (i == o.i ? 0 : 1));
    }
}

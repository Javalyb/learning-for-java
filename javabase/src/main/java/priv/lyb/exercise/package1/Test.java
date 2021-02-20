package priv.lyb.exercise.package1;

import java.util.Objects;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 16:58 2021/02/19
 */
public class Test {
    private String a;
    private Integer b;
    private Float c;
    private int d;

    public Test(String a, Integer b, Float c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public static void main(String[] args) {
        Test t1 = new Test("a", 1, 1f, 1);
        Test t2 = new Test("a", 1, 1f, 1);
        System.out.println(t1 == t2);
        System.out.println(t1.equals(t2));

        String a = new String("a");
        a = new String("b");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        Test test = (Test) o;
        return d == test.d && a.equals(test.a) && b.equals(test.b) && c.equals(test.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

}

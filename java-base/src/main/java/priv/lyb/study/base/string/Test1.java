package priv.lyb.study.base.string;

/**
 * @Author: apollo
 * @Description:
 * @Date: 19:30 2021/03/18
 */
public class Test1 {
    public static void main(String[] args) {
        String s0 = "ab";
        final String s1 = "b";
        String s2 = "a" + s1;
        System.out.println((s0 == s2));
    }
}

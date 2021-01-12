package priv.lyb.study.base.exception;

/**
 * @author LiuYingBo 2021/01/12 11:47
 */
public class Test {
    public static String fun6() {
        String a = "1";
        try {
            a = "3";
            return a;
        } catch (Exception e) {

        } finally {
            a = "2";
            return a;
        }
    }
}

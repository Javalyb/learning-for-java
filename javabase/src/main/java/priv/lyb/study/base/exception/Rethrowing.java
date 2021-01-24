package priv.lyb.study.base.exception;

/**
 * @author LiuYingBo 2021/01/24 16:27
 */
public class Rethrowing {
    static void f() throws Exception{
        System.out.println("Rethrowing f");
        throw new Exception("Rethrowing f Exception");
    }

    static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw e;
        }
    }

    static void h() throws Exception {
        try {
            g();
        } catch (Exception e) {
            e.printStackTrace(System.out);
//            throw e;
            throw (Exception)e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        System.out.println("-------------------------------");

        try {
            h();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}

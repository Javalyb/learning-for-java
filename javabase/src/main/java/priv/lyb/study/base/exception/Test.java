package priv.lyb.study.base.exception;

/**
 * @author LiuYingBo 2021/01/12 11:47
 */
public class Test {
    @org.junit.Test
    public void fun() {
        System.out.println(Test.fun1());
    }

    /**
     * 1.finally总会执行；
     * 2.finally有返回值时，只会返回finally中的值；
     * 3.finally没有返回值，try或catch有返回值时。先会保存try或catch中的值，等finally执行完后，再返回try或catch中的值；
     */
    public static String fun1() {
        String a = "1";
        try {
            System.out.println("when go to try a = " + a);
            a = "3";
//            throw new Exception();
            return a;
        } catch (Exception e) {
            System.out.println("when go to catch a = " + a);
            a = "4";
            return a;
        } finally {
            System.out.println("when go to finally a = " + a);
            a = "2";
//            return a;
        }
    }
}

package priv.lyb.study.base.exception;

import org.junit.jupiter.api.Test;

/**
 * @author LiuYingBo 2021/01/12 11:47
 */
public class Finally {
    @Test
    public void fun() {
        System.out.println(Finally.fun1());
    }

    /**
     * 1.finally总会执行(前提是finally之前程序没有退出: 执行System.exit(0))；
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
            System.out.println("when go to finally a = " + a);
//            return a;
        }
    }

    @Test
    public void fun2() {
        System.out.println("Entering first try block");
        try {
            try {
                System.out.println("Entering second try block");
                throw new FourException();
            }finally {
                System.out.println("finally in 2nd try block");
            }
        }catch (FourException e){
            System.out.println("Caught FourException in 1st try block");
        }finally {
            System.out.println("finally in 1nd try block");
        }
    }

    @Test
    public void fun3() throws Exception{
        try {
            System.out.println("1");
            throw new Exception();
        }catch (Exception e){
            System.out.println("2");
            throw new Exception();
        }finally {
            System.out.println("3");
            throw new Exception();
//            return;
        }
    }
}

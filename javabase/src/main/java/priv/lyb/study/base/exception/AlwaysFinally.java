package priv.lyb.study.base.exception;

/**
 * @author LiuYingBo 2021/01/24 19:30
 */
class FourException extends Exception{}
public class AlwaysFinally {
    public static void main(String[] args) {
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
}

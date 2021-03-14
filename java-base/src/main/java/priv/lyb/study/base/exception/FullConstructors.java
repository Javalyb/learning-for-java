package priv.lyb.study.base.exception;

/**
 * @author LiuYingBo 2021/01/24 04:20
 */
class MyException extends Exception{
    MyException(){}
    MyException(String msg){
        super(msg);
    }
}
public class FullConstructors {
    static void f() throws MyException{
        System.out.println("Throwing MyException from f");
        throw new MyException();
    }

    static void g() throws MyException{
        System.out.println("Throwing MyException from g");
        throw new MyException("Originated in g");
    }

    public static void main(String[] args) {
        try{
            FullConstructors.f();
        }catch (MyException e){
//            e.printStackTrace(System.err);
            e.printStackTrace(System.out);
        }

        try{
            FullConstructors.g();
        }catch (MyException e){
            e.printStackTrace(System.out);
        }

    }
}

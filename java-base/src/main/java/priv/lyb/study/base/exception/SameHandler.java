package priv.lyb.study.base.exception;

/**
 * @author LiuYingBo 2021/01/24 15:53
 */
class EBase1 extends Exception{}
class Except1 extends EBase1{}

class EBase2 extends Exception{}
class Except2 extends EBase2{}

class EBase3 extends Exception{}
class Except3 extends EBase3{}

public class SameHandler {
    void x() throws Except1,Except2,Except3{
    };

    void f(){
        try {
            x();
        } catch (Except1 | Except2 | Except3 except1) {
            except1.printStackTrace();
        }
    }
}

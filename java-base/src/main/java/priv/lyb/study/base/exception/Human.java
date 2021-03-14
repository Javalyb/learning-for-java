package priv.lyb.study.base.exception;

/**
 * @author LiuYingBo 2021/01/24 22:26
 */
class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class Human {
    static void fun() throws Annoyance,Sneeze{

    }
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Sneeze sneeze) {
            System.out.println("Cneeze " + sneeze);
        } catch (Annoyance annoyance) {
            System.out.println("Annoyance " + annoyance);
        }


    }
}

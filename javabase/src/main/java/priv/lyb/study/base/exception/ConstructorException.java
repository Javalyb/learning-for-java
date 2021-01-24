package priv.lyb.study.base.exception;

/**
 * @author LiuYingBo 2021/01/24 21:56
 */
class CE extends Exception {
}

class SecondExcept extends Reporter {
    SecondExcept() throws CE {
        throw new CE();
    }
}

public class ConstructorException {
    public static void main(String[] args) {
        try (
                First first = new First();
                SecondExcept secondExcept = new SecondExcept();
                Second second = new Second();
        ) {
            System.out.println("In body");
        } catch (CE ce) {
            System.out.println("Caught " + ce);
        }
    }
}

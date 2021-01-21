package priv.lyb.study.base.annotation.ohjava.annotations;

/**
 * @author LiuYingBo 2021/01/15 13:21
 */
public class Testable {
    public void execute(){
        System.out.println("execute");
    }

    @Test
    void testExecute(){
        execute();
    }
}

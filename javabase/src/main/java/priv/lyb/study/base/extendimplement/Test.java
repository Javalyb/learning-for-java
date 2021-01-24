package priv.lyb.study.base.extendimplement;

/**
 * @author LiuYingBo 2021/01/20 22:49
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void fun(){
        AbstractA a = new AbstractA(5){
            @Override
            public void abstractA_abstract_fun1() {

            }
        };
        System.out.println(a.a);
    }
}

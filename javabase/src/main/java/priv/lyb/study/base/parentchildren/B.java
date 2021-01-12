package priv.lyb.study.base.parentchildren;

/**
 * @author LiuYingBo 2021/1/4 上午1:40
 */
public class B extends A {
    Integer i = 20;
    static Integer i1 = 25;
    B(){
    }

    @Override
    void a() {
        System.out.println("B.a");
    }
}

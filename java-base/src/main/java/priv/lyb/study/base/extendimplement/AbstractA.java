package priv.lyb.study.base.extendimplement;

/**
 * @author LiuYingBo 2021/01/20 19:22
 */
public abstract class AbstractA{
    public int a;
    public AbstractA(int a){
        System.out.println("AbstractA 初始化");
        this.a = a;
    }
    public abstract void abstractA_abstract_fun1();
    public void abstractA_fun1(){

    }
}

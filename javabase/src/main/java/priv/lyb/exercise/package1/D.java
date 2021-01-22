package priv.lyb.exercise.package1;

/**
 * @author LiuYingBo 2021/01/22 17:01
 */
public class D implements C{
    @Override
    public void fun1() {
        System.out.println("D fun1");
    }

    public void fun2(){
        System.out.println("D fun2");
    }

    public static void main(String[] args) {
        C c = new D();
    }
}

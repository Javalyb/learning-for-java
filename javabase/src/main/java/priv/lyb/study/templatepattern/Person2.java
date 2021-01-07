package priv.lyb.study.templatepattern;

/**
 * @author LiuYingBo 2021/1/4 上午1:03
 */
public class Person2 extends priv.lyb.study.templatepattern.RestaurantTemplate {
    @Override
    public void menu() {
        System.out.println("多看下菜单");
    }

    @Override
    public void spotMenu() {
        System.out.println("鱼翅");
    }

    @Override
    public void payment() {
        System.out.println("20块");
    }
}

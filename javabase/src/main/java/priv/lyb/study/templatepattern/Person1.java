package priv.lyb.study.templatepattern;

/**
 * @author LiuYingBo 2021/1/4 上午1:01
 */
public class Person1 extends priv.lyb.study.templatepattern.RestaurantTemplate {

    @Override
    public void menu() {
        System.out.println("看2下菜单");
    }

    @Override
    public void spotMenu() {
        System.out.println("鲍鱼");
    }

    @Override
    public void payment() {
        System.out.println("10块");
    }


}

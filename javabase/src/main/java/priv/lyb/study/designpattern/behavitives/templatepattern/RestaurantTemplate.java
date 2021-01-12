package priv.lyb.study.designpattern.behavitives.templatepattern;

/**
 * @author LiuYingBo 2021/1/4 上午12:55
 */
public abstract class RestaurantTemplate {
    //看菜单
    public void menu() {
        System.out.println("看菜单");
    }

    //点餐
    public abstract void spotMenu();

    //吃饭
    public void havingDinner() {
        System.out.println("吃饭");
    }

    //付款
    public abstract void payment();

    //走人
    public void goR() {
        System.out.println("走人");
    }

    public void process() {
        menu();
        spotMenu();
        havingDinner();
        payment();
        goR();
    }
}

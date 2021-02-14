package priv.lyb.study.designpattern.structural.decorator.exercise2;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 22:11 2021/02/14
 */
public class Test {
    public static void main(String[] args) {
        Cofe cofeChina = new CofeChina(5.5f);
        System.out.println("中式咖啡价格："+cofeChina.price());

        cofeChina = new Sugar(cofeChina);
        System.out.println("中式咖啡加糖后价格："+cofeChina.price());
    }
}

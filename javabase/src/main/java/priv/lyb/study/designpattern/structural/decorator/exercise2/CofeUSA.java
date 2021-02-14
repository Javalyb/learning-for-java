package priv.lyb.study.designpattern.structural.decorator.exercise2;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 21:38 2021/02/14
 */
public class CofeUSA extends Cofe{
    private float price;
    CofeUSA(float price){
        this.price = price;
    }
    @Override
    float price() {
        return price;
    }
}

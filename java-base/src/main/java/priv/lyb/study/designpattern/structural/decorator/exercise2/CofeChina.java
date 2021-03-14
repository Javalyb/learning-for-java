package priv.lyb.study.designpattern.structural.decorator.exercise2;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 21:38 2021/02/14
 */
public class CofeChina extends Cofe{
    private float price;
    CofeChina(float price){
        this.price = price;
    }

    @Override
    public float price() {
        return price;
    }
}

package priv.lyb.study.designpattern.structural.decorator.exercise2;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 21:46 2021/02/14
 */
public class Sugar extends Decorator{
    private float price = 1.1f;
    Sugar(Cofe cofe) {
        super(cofe);
    }

    @Override
    public float price() {
        return this.price + super.cofe.price();
    }
}

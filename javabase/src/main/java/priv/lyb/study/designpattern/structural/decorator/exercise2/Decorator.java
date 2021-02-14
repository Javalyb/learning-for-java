package priv.lyb.study.designpattern.structural.decorator.exercise2;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 21:39 2021/02/14
 */
public abstract class Decorator extends Cofe {
    Cofe cofe;
    Decorator(Cofe cofe) {
        this.cofe = cofe;
    }

    public abstract float price();
}

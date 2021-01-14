package priv.lyb.study.genericity.thinkingjavafour.generics;

/**
 * @author LiuYingBo 2021/01/13 15:23
 */
class Automobile{}

public class Holder1 {
    private Automobile automobile;

    public Holder1(Automobile automobile) {
        this.automobile = automobile;
    }

    Automobile get() {
        return this.automobile;
    }
}



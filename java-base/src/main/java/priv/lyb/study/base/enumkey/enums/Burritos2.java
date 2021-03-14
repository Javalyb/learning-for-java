package priv.lyb.study.base.enumkey.enums;

/**
 * @author LiuYingBo 2021/01/15 19:33
 */
import static priv.lyb.study.base.enumkey.enums.SpicinessEnum.*;
public class Burritos2 {
    SpicinessEnum degree;
    public Burritos2(SpicinessEnum degree){
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + this.degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burritos2(NOT));
        System.out.println(new Burritos2(MILD));
    }
}

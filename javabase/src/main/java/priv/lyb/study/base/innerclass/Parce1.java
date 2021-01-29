package priv.lyb.study.base.innerclass;

import javax.print.attribute.standard.Destination;

/**
 * @author LiuYingBo 2021/01/21 15:11
 */
public class Parce1 {
    class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }

    class Destination{
        private String label;

        Destination(String whereTo){
            this.label = whereTo;
        }

        String readLabel(){
            return label;
        }
    }

    public void ship(String dest){
        Contents contents = new Contents();
        Destination destination = new Destination(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parce1 parce1 = new Parce1();
        parce1.ship("Tasmainia");
    }
}

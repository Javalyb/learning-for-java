package priv.lyb.study.base.innerclass;

import javax.print.attribute.standard.Destination;

/**
 * @author LiuYingBo 2021/01/21 15:11
 */
public class Parce2 {
    int a = 1;
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

    public Destination to(String s){
        return new Destination(s);
    }

    public Contents contents(){
        return new Contents();
    }

    public void ship(String dest){
        Contents contents = new Contents();
        Destination destination = new Destination(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parce2 parce1 = new Parce2();
        parce1.ship("Tasmainia");
        Parce2.Contents contents = parce1.contents();
        System.out.println(contents.value());
        Parce2.Destination destination = parce1.to("Borneo");
        System.out.println(destination.readLabel());
    }
}

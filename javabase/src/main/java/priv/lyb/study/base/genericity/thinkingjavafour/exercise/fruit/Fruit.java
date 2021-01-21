package priv.lyb.study.base.genericity.thinkingjavafour.exercise.fruit;

/**
 * @author LiuYingBo 2021/01/14 23:07
 */
public class Fruit {
    public Fruit(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

package priv.lyb.study.base.genericity.thinkingjavafour.util;

/**
 * @author LiuYingBo 2021/01/14 18:06
 */

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class CovariantArrays {
    public static void main(String[] args) {
        /*Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        //Exception in thread "main" java.lang.ArrayStoreException:
        fruit[2] = new Fruit();*/

        //compile error
        /*List<? extends Fruit> a = new ArrayList<Apple>();
        a.add(new Apple());*/

    }
}

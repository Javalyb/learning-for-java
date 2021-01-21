package priv.lyb.study.base.genericity.thinkingjavafour.exercise.fruit;

/**
 * @author LiuYingBo 2021/01/14 23:11
 */

public class Test {


    public static void main(String[] args) {
        GenericHolder<Fruit> fruitGenericHolder = new GenericHolder<>();
        GenericHolder<Apple> appleGenericHolder = new GenericHolder<>();

        Fruit fruit = new Fruit("水果");
        Apple apple = new Apple("苹果");

        fruitGenericHolder.setObj(fruit);
        System.out.println(fruitGenericHolder.getObj().getName());

        fruitGenericHolder.setObj(apple);
        System.out.println(fruitGenericHolder.getObj().getName());

        Apple fruit2 = (Apple)fruitGenericHolder.getObj();
        System.out.println(fruit2.getName());

        fruitGenericHolder.setObj(fruit2);
        System.out.println(fruitGenericHolder.getObj().getName());

        Fruit fruit1 = fruitGenericHolder.getObj();
        System.out.println(fruit1.getName());

        fruitGenericHolder.setObj(fruit1);
        System.out.println(fruitGenericHolder.getObj().getName());
    }

}

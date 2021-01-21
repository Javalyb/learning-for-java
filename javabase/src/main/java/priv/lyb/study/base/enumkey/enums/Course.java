package priv.lyb.study.base.enumkey.enums;

import java.util.Random;

/**
 * @author LiuYingBo 2021/01/16 00:17
 */
public enum Course {
    APPETIZER(Foods.Appetizer.class),
    MAINCOURSE(Foods.MainCourse.class),
    DESSERT(Foods.Dessert.class),
    COFFEE(Foods.Coffee.class);

    private Foods [] foods;
    Course(Class<? extends Foods> t) {
        foods = t.getEnumConstants();
    }

    public Foods randomSelection(){
        return foods[new Random().nextInt(foods.length)];
    }

    public static void main(String[] args) {
        System.out.println(Course.APPETIZER.randomSelection());
        System.out.println("-----------------------");

        for (Course value : Course.values()) {
            System.out.println(value.randomSelection());
        }
    }
}

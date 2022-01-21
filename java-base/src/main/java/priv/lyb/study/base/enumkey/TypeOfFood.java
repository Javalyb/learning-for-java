package priv.lyb.study.base.enumkey;

import priv.lyb.study.base.enumkey.Foods;

/**
 * @author LiuYingBo 2021/01/16 00:06
 */

//import static priv.lyb.study.base.enumkey.Foods.*;

public class TypeOfFood {
    public static void main(String[] args) {
        Foods food = Foods.Appetizer.SALAD;
        food = Foods.MainCourse.LASAGNE;
        food = Foods.Dessert.TIRAMISU;
        food = Foods.Coffee.BLACK_COFFEE;
    }
}

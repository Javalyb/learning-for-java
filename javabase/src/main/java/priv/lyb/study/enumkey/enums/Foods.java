package priv.lyb.study.enumkey.enums;

/**
 * @author LiuYingBo 2021/01/16 00:01
 */
public interface Foods {
    enum Appetizer implements Foods{
        SALAD, SOUP, SPRING_ROLLS
    }

    enum MainCourse implements Foods{
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO
    }

    enum Dessert implements Foods{
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL
    }

    enum Coffee implements Foods{
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA
    }
}

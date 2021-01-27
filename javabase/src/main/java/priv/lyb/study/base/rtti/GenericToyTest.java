package priv.lyb.study.base.rtti;

/**
 * @author LiuYingBo 2021/01/26 16:44
 */
public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> fancyToyClass = FancyToy.class;
        FancyToy fancyToy = fancyToyClass.newInstance();
        Class<? super FancyToy> superClass = fancyToyClass.getSuperclass();
        //getSuperClass返回的是父类的类型对象(Class对象)。
        //这个父类的类型对象并不确定(可能集联继承)，
        //所以通过通配符对象的newInstance返回的是一个不确定的Object对象;
//        Class<Toy> superClass1 = fancyToyClass.getSuperclass();
    }
}

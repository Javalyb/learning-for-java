package priv.lyb.study.base.rtti;

/**
 * @author LiuYingBo 2021/01/26 16:24
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        genericIntClass = Integer.TYPE;
        intClass = double.class;
//        genericIntClass = Double.class;

        Class<?> numberClass = int.class;
    }
}

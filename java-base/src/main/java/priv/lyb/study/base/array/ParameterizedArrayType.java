package priv.lyb.study.base.array;

/**
 * @author LiuYingBo 2021/01/27 22:50
 */
class ClassParameter<T> {
    public T[] f(T[] t) {
        return t;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] t) {
        return t;
    }
}

public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = MethodParameter.f(doubles);

        System.out.println("ints2: " + ints2);
        System.out.println("doubles2: " + doubles2);
    }
}

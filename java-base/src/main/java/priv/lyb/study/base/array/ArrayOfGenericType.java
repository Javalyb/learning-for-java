package priv.lyb.study.base.array;

/**
 * @author LiuYingBo 2021/01/27 23:55
 */

@SuppressWarnings("unchecked")
public class ArrayOfGenericType<T> {
    T[] t;
    public ArrayOfGenericType(int size){
        this.t = (T[]) new Object[size];
    }


    public static void main(String[] args) {
//        Object[] o1 = new Object[]{1,2,3};
//        Integer[] o2 = (Integer[])o1;


        ArrayOfGenericType<String> arrayOfGenericType = new ArrayOfGenericType<>(10);
        String[] s = (String[]) arrayOfGenericType.t;
        System.out.println(s);
    }
}

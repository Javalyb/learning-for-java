package priv.lyb.study.base.genericity.thinkingjavafour.util;

/**
 * @author LiuYingBo 2021/01/14 20:21
 */
public class Generic<T> {
    private T key;
    public Generic(T key){
        this.key = key;
    }
    public T getKey(){
        return key;
    }
    public static void showKeyValue1(Generic<?> obj){
        System.out.println("泛型测试, key value is " + obj.getKey());
    }

    public static void main(String[] args) {
        Generic<Integer> a = new Generic<>(123);
        Generic<Number> b = new Generic<>(456);
        showKeyValue1(a);
        showKeyValue1(b);
    }
}

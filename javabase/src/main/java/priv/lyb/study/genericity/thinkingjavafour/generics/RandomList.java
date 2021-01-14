package priv.lyb.study.genericity.thinkingjavafour.generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author LiuYingBo 2021/01/13 17:38
 */
public class RandomList<T> {
    private final ArrayList<T> arrayList = new ArrayList<>();
    private final Random random = new Random(47);

    public void add(T t) {
        arrayList.add(t);
    }

    public T select() {
        return arrayList.get(random.nextInt(arrayList.size()));
    }

    public static void main(String[] args) {
        RandomList<String> a = new RandomList<>();
        String[] b = "a b c d".split(" ");
        for (String s : b) {
            a.add(s);
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println(a.select());
        }
    }
}

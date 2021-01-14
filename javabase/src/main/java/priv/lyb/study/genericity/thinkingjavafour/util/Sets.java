package priv.lyb.study.genericity.thinkingjavafour.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiuYingBo 2021/01/14 16:34
 */
public class Sets {
    public static <T> Set<T> union(Set<T> t1, Set<T> t2,T t) {
        Set<T> result = new HashSet<>(t1);
        result.add(t);
        result.addAll(t2);
        return result;
    }

    public static void main(String[] args) {
        Set<HashSet> a = Sets.union(new HashSet<>(),new HashSet(),new HashSet());
        System.out.println(a.size());
    }
}

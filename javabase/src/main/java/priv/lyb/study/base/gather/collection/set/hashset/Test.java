package priv.lyb.study.base.gather.collection.set.hashset;

import java.util.HashSet;

/**
 * @author LiuYingBo 2021/01/21 22:01
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void fun(){
        HashSet<String> set = new HashSet<>();
        set.add("001");
        System.out.println(set.size());
        set.add("001");
        System.out.println(set.size());
    }
}

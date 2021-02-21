package priv.lyb.study.base.iterable.collections;

import java.util.*;

/**
 * @author LiuYingBo 2021/01/22 14:35
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void fun(){
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer [] moreInts = {6,7,8,9};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection,moreInts);
        Collections.addAll(collection,1,2,3,4,5);
        System.out.println(collection);

        List<Integer> list = Arrays.asList(1,2,3);
        list.set(1,22);
        System.out.println(list.toString());

//        list.add(4);  //Exception
        System.out.println(list);


    }
}

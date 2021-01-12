package priv.lyb.study.collection.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/08 20:57
 */
public class Test1 {
    @org.junit.Test
    public void fun() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("");

        List<String> list = Collections.synchronizedList(arrayList);
        list.add("");

        Integer[] strArr = {1, 2, 3};
        strArr = Arrays.copyOf(strArr, 4);
        System.out.println(Arrays.toString(strArr));
        strArr[3] = 4;
        System.out.println(strArr.length);
        System.out.println(Arrays.toString(strArr));
    }
}

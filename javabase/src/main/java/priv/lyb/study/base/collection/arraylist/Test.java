package priv.lyb.study.base.collection.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/08 20:57
 * 扩充：根据之前长度默认扩充1.5倍，扩充后长度小于当前数据长度取当前数据长度，否则取扩充后长度；
 * add：Arrays.copyOf(当前数组,扩充后新长度)；
 * remove：之后数据前移，最后数据为null；
 * 并发问题替代方案：Vertor,Collections.synchronizedList,JUC.CopyOnWriteArrayList；
 */
public class Test {
    @org.junit.Test
    public void fun() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("");
        arrayList.add("");

        List<String> list = Collections.synchronizedList(arrayList);
        list.add("01");
        list.add("02");
        list.add("03");

        Integer[] strArr = {1, 2, 3};
        strArr = Arrays.copyOf(strArr, 4);
        System.out.println(Arrays.toString(strArr));
        strArr[3] = 4;
        System.out.println(strArr.length);
        System.out.println(Arrays.toString(strArr));

        System.out.println(arrayList.size());
        arrayList.set(0, "000");
        System.out.println("------" + arrayList);


        System.out.println(arrayList.remove(arrayList.size() - 2));
        System.out.println(arrayList.toString());


    }
}

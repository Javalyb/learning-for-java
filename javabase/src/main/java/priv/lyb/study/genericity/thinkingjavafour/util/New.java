package priv.lyb.study.genericity.thinkingjavafour.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuYingBo 2021/01/14 15:55
 */
public class New {
    //类型推断
    static <K, V> Map<K,V> map(){
        return new HashMap<K,V>();
    }

    public static void main(String[] args) {
        Map<String, List<ArrayList<Map<String, String>>>> a = New.map();
        a.put("a",new ArrayList());
        List c = a.get("a");
        System.out.println(c);

    }
}

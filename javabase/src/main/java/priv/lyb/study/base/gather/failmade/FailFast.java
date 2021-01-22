package priv.lyb.study.base.gather.failmade;

import org.junit.Test;

import java.util.*;

/**
 * @author LiuYingBo 2021/01/10 13:07
 */
public class FailFast {
    @Test
    public void fun() {
        List<String> list = new ArrayList<>();
        list.add("1");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
//            list.set(0,"1");
            list.remove(0);
            iterator.remove();
//            list.add("1");
        }
    }

    @Test
    public void fun1() {
        List<String> list = new ArrayList<>();
        list.add("1");
        for (String a : list) {
            list.remove(a);
        }
    }

    @Test
    public void fun3() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("1", "1");
        hashtable.put("2", "2");
        hashtable.put("3", "3");
        for (String str : hashtable.keySet()) {
            System.out.println(str);
            hashtable.remove(str);
        }
        System.out.println(hashtable.keySet().size());
    }

    @Test
    public void fun4() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        for (String str : linkedList) {
            System.out.println(str);
            linkedList.remove(0);
        }
    }
}

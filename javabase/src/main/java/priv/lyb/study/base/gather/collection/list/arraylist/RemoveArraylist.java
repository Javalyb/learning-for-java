package priv.lyb.study.base.gather.collection.list.arraylist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/21 21:38
 */
public class RemoveArraylist {
    @Test
    public void fun(){
        List<String> list = new ArrayList<>();
        list.add("001");
        list.add("002");
        list.add("003");
        list.add("004");
        list.add("005");
        list.add("006");
        list.add("007");
        list.add("008");
        list.add("009");
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("008")){
                list.remove(i);
            }
        }
        System.out.println(list.toString());
        System.out.println(list.size());
    }
}

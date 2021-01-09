package priv.lyb.study.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/08 22:23
 * 单向链表：每个节点存了数据和指向下一个节点的引用
 *      适用范围：新增和删除
 * 双向链表：除每个节点存了数据和指向下一个节点的引用外，还存了指向上一个节点的引用
 *      适用范围：查询
 */
public class Test {
    @org.junit.Test
    public void fun(){
        System.out.println(System.currentTimeMillis());
        List<String> list = new LinkedList<>();
        for (int i=0;i<10000;i++){
            list.add(String.valueOf(i));
        }
        System.out.println(list.indexOf("5"));
        System.out.println(list.lastIndexOf("5"));
        System.out.println(System.currentTimeMillis());
    }
}

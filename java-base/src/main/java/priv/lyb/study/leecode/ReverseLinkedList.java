package priv.lyb.study.leecode;

import lombok.val;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @description: 反转链表
* @author: lyb
* @create: 2026-06-07 23:05
**/
public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    //反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;


        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    //构建链表
    private static ListNode buildList(int [] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int val : arr) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode buildListNode = buildList(new int[]{1,2,3,4,5});
        ListNode prev = reverseLinkedList.reverseList(buildListNode);
        System.out.println(prev);


        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> list2 = list1;
        list1 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println(list1.toString());
        System.out.println(list1==list2);
    }

}
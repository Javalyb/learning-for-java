package priv.lyb.study.leecode;

import com.sun.jmx.remote.internal.ArrayQueue;

import javax.management.Query;
import java.util.Deque;
import java.util.Queue;

/**
* @description: 
* @author: lyb
* @create: 2026-06-13 15:55
**/


/*
设计实现双端队列。

实现 MyCircularDeque 类:

MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 */
public class Solution641 {

    private Deque<Integer> deque;


    public Solution641(int k) {
        new ArrayQueue<Integer>(k);
    }

    public boolean insertFront(int value) {
        if(!deque.isEmpty()){
            return deque.offerFirst(value);
        }
        return false;
    }


    public boolean insertLast(int value) {
        if(!deque.isEmpty()){
            return deque.offerLast(value);
        }
        return false;
    }

    public boolean deleteFront() {
        return false;
    }

    public boolean deleteLast() {
        return false;
    }

    public int getFront() {
        return 0;
    }

    public int getRear() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isFull() {
        return false;
    }
}
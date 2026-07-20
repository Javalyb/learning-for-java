package priv.lyb.study.leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
* @description: 
* @author: lyb
* @create: 2026-06-13 15:24
**/
public class Solution933 {

    private Queue<Integer> queue;


    public Solution933() {
        queue = new LinkedList<>();
    }


    public int ping(int t) {

        queue.offer(t);

        int min = t - 3000;

        while(!queue.isEmpty() && queue.peek() < min){
            queue.poll();
        }


        return queue.size();
    }


}
package priv.lyb.study.concurrent.thread;

import java.util.Arrays;

/**
 * @author LiuYingBo 2021/02/01 03:32
 */
public class CircularSet {
    private int[] array;
    private int size;
    private int index = 0;

    public CircularSet(int size) {
        this.size = size;
        array = new int[size];
        Arrays.fill(array, -1);
    }

    public synchronized void add(int i){
        array[index]=i;
        index = ++index % size;
    }

    public synchronized boolean contains(int val){
        for (int i = 0; i < size; i++) {
            if(array[i]==val){
                return true;
            }
        }
        return false;
    }
}

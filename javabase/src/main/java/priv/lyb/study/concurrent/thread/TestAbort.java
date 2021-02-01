package priv.lyb.study.concurrent.thread;

import priv.lyb.study.concurrent.threadpool.Nap;

/**
 * @author LiuYingBo 2021/01/31 21:05
 */
public class TestAbort {
    public static void main(String[] args) {
        new TimeAbort(1);
        new Nap(4);
    }
}

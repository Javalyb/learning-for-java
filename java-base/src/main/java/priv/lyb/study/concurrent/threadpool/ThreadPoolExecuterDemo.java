package priv.lyb.study.concurrent.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
* @description: 
* @author: lyb
* @create: 2026-07-19 23:17
**/
public class ThreadPoolExecuterDemo {

    //核心线程数->队列->最大线程数->拒绝策略（主线程执行或者抛出异常）

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4, //核心线程数
                4, //最大线程数
                0l, //空闲线程存活时间
                TimeUnit.SECONDS, //空闲线程存活时间单位
                new LinkedBlockingDeque<>(100), //有界任务队列
                new ThreadPoolExecutor.CallerRunsPolicy() //拒绝策略(由主线程执行，或者默认抛出异常（AbortPolicy）)
        );

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        //关闭
        threadPoolExecutor.shutdown();
    }

}
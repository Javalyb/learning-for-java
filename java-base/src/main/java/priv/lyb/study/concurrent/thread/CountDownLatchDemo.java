package priv.lyb.study.concurrent.thread;

import java.util.concurrent.CountDownLatch;

/**
* @description: 
* @author: lyb
* @create: 2026-07-19 23:00
**/
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {

            new Thread(() -> {

                try {
                    System.out.println("执行任务");
                } finally {
                    //计数器减一
                    latch.countDown();
                }
            });

        }

        //等待计数器归零,当计数器变成 0 后，所有等待中的线程继续执行
        latch.await();

        System.out.println("所有任务执行完成，开始执行后续任务");

    }

}
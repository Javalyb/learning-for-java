package priv.lyb.study.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 17:42 2021/02/22
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-start1");
            countDownLatch.countDown();
        });

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-start2");
        });

        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-start3");
        });

        try {
            t1.start();
            countDownLatch.await();
            t2.start();
            countDownLatch.await();
            t3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

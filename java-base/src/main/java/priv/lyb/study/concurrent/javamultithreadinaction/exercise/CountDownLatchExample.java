package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYingBo 2021/02/04 21:29
 */
public class CountDownLatchExample {
    private static final CountDownLatch latch = new CountDownLatch(4);
    private static int data = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data = i;
                    latch.countDown();
                    latch.countDown();
                    System.out.println("i: " + latch.getCount());
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("main");
        thread.start();
        latch.await();
        System.out.println("data: " + data);
    }
}

package priv.lyb.study.concurrent.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 17:52 2021/02/22
 */
public class CyclicBarrierTest {
    private final static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("runnable start"));

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-start1");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-start2");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-start3");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }


    private static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("thread1 run");
            for (int i = 0; i < 3; i++) {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

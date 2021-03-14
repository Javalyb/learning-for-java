package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYingBo 2021/02/02 01:00
 */
public class ThreadCreationCmp {
    public static void main(String[] args) {
        Thread t;
        int processors = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < 2 * processors; i++) {
            t = new Thread(new CountingTask());
            t.start();
        }

        for (int i = 0; i < 2 * processors; i++) {
            t = new CountingThread();
            t.start();
        }
    }

    static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int value() {
            return count;
        }
    }

    private static class CountingTask implements Runnable {
        private Counter counter = new Counter();
        private SplittableRandom random = new SplittableRandom(47);

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("CountingTask: " + counter.value());
        }

        private void doSomething() {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextLong(0, 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class CountingThread extends Thread {
        private Counter counter = new Counter();
        private SplittableRandom random = new SplittableRandom(47);

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("CountingThread: " + counter.value());
        }

        private void doSomething() {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextLong(0, 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

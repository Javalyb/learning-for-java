package priv.lyb.study.concurrent.lock.volatilekey;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuYingBo 2021/01/31 23:11
 */
public class Test {
    volatile int number = 10;

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(() -> {
            try {
                System.out.println("子线程 step1: " + test.number);
                TimeUnit.MILLISECONDS.sleep(5000);
                System.out.println("子线程 step2: " + test.number);
                test.modify();
                System.out.println("子线程 step3: " + test.number);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

        System.out.println("主线程 step2: " + test.number);
        while (test.number != 10) {
            test.number = test.number - 3;
        }
        System.out.println("主线程 step3: " + test.number);
        System.out.println(Thread.currentThread().getName() + "---------------" + test.number);
    }

    void modify() {
        this.number = this.number - 7;

    }
}



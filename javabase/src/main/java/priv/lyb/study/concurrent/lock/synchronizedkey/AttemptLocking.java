package priv.lyb.study.concurrent.lock.synchronizedkey;

import priv.lyb.study.concurrent.threadpool.Nap;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuYingBo 2021/02/01 05:06
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        CompletableFuture.runAsync(() -> {
            al.lock.unlock();
            System.out.println("accquired");
        });
        new Nap(0.1);
        al.untimed();
        al.timed();
    }

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock: " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("lock.tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }
}

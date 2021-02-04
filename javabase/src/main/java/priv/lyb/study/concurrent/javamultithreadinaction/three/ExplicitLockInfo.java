package priv.lyb.study.concurrent.javamultithreadinaction.three;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuYingBo 2021/02/04 01:02
 */
public class ExplicitLockInfo {
    private static final Lock lock = new ReentrantLock();
    private static int sharedData = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
                sharedData = 1;
            } catch (Exception e) {
                throw new Error(e);
            } finally {
                lock.unlock();
            }
        }).start();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            lock.lock();
            System.out.println("sharedData: " + sharedData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

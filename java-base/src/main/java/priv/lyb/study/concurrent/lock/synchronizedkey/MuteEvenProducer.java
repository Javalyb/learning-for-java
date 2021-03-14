package priv.lyb.study.concurrent.lock.synchronizedkey;

import priv.lyb.study.concurrent.thread.EvenChecker;
import priv.lyb.study.concurrent.thread.IntGenerator;
import priv.lyb.study.concurrent.threadpool.Nap;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuYingBo 2021/02/01 04:55
 */
public class MuteEvenProducer extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try {
//            ++currentEvenValue;
            new Nap(0.01);
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MuteEvenProducer());
    }
}

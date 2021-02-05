package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author LiuYingBo 2021/02/04 02:01
 */
public class ReadWriterLockUsage {
    private static final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static final Lock readLock = rwLock.readLock();
    private static final Lock writeLock = rwLock.writeLock();

    public void reader() {
        readLock.lock();
        try {

        } finally {
            readLock.unlock();
        }
    }

    public void writer() {
        writeLock.lock();
        try {

        } finally {
            writeLock.unlock();
        }
    }
}

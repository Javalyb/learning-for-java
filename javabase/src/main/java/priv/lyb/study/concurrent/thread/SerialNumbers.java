package priv.lyb.study.concurrent.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiuYingBo 2021/02/01 03:30
 */
public class SerialNumbers {
    private AtomicInteger serialNumber = new AtomicInteger();
    public synchronized int nextSerialNumber(){
        return serialNumber.getAndIncrement();
    }
}

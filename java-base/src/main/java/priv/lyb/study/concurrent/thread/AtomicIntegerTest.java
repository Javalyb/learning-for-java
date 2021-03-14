package priv.lyb.study.concurrent.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiuYingBo 2021/02/01 03:49
 */
public class AtomicIntegerTest extends IntTestable{
    private AtomicInteger i = new AtomicInteger(0);
    @Override
    public int getAsInt() {
        return i.get();
    }

    @Override
    public void evenIncrement() {
        i.addAndGet(2);
    }

    public static void main(String[] args) {
        Atomicity.test(new AtomicIntegerTest());
    }

}

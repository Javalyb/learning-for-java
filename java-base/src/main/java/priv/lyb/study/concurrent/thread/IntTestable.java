package priv.lyb.study.concurrent.thread;

import java.util.function.IntSupplier;

/**
 * @author LiuYingBo 2021/01/31 23:56
 */
public abstract class IntTestable implements Runnable, IntSupplier {
    public abstract void evenIncrement();

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

}

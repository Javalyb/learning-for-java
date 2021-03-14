package priv.lyb.study.concurrent.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author LiuYingBo 2021/01/31 18:05
 */
public abstract class IntGenerator {
    private AtomicBoolean canceled = new AtomicBoolean();
    public abstract int next();
    public void cancel(){
        canceled.set(true);
    }
    public boolean isCanceled(){
        return canceled.get();
    }
}

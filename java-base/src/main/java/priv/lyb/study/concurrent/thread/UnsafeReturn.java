package priv.lyb.study.concurrent.thread;

/**
 * @author LiuYingBo 2021/02/01 03:18
 */
public class UnsafeReturn extends IntTestable{
    private int i = 0;
    @Override
    public synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public synchronized int getAsInt() {
        return i;
    }

    public static void main(String[] args) {
        Atomicity.test(new UnsafeReturn());
    }
}

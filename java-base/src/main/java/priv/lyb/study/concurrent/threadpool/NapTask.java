package priv.lyb.study.concurrent.threadpool;

/**
 * @author LiuYingBo 2021/01/30 17:28
 */
public class NapTask implements Runnable {
    final int id;

    NapTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        new NapTask(10);
        System.out.println(this + " " + Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return "Nap[" + id + "]";
    }
}

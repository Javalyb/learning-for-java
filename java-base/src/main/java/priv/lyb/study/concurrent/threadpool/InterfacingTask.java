package priv.lyb.study.concurrent.threadpool;

/**
 * @author LiuYingBo 2021/01/30 21:39
 */
public class InterfacingTask implements Runnable {
    final int id;
    private Integer val = 0;

    InterfacingTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " + Thread.currentThread().getName() + " " + val);
    }
}

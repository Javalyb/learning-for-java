package priv.lyb.study.concurrent.threadpool;

import java.util.concurrent.Callable;

/**
 * @author LiuYingBo 2021/01/30 22:09
 */
public class CountingTask implements Callable<Integer> {
    private int id;

    CountingTask(int id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        Integer val = 0;
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " + Thread.currentThread().getName() + " " + val);
        return val;
    }
}

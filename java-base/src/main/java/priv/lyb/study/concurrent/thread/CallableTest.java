package priv.lyb.study.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 21:32 2021/02/21
 */
public class CallableTest {
    public static void main(String[] args) {
        new Thread(new FutureTask<Integer>(() -> {
            System.out.println("1111");
            return 1;
        }) {
        }).start();


        ExecutorService es = Executors.newSingleThreadExecutor();
        Future future = es.submit(()->{});
        future.isDone();
    }
}

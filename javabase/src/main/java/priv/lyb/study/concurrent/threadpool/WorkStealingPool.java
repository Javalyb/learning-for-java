package priv.lyb.study.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author LiuYingBo 2021/01/31 16:49
 */
class ShowThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class WorkStealingPool {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newWorkStealingPool();
        IntStream.range(0, 100)
                .mapToObj(n -> new ShowThread())
                .forEach(executorService::execute);
        executorService.awaitTermination(1, TimeUnit.SECONDS);
    }
}

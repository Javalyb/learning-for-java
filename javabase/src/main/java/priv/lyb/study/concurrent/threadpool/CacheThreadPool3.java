package priv.lyb.study.concurrent.threadpool;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author LiuYingBo 2021/01/30 22:14
 */
public class CacheThreadPool3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<CountingTask> tasks = IntStream.range(0,100)
                .mapToObj(CountingTask::new)
                .collect(Collectors.toList());
        List<Future<Integer>> future = executorService.invokeAll(tasks);
        for (Future<Integer> integerFuture : future) {
            System.out.println(integerFuture.get());
        }
        executorService.shutdown();
    }
}

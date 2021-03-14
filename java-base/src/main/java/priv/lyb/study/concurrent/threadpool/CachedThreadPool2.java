package priv.lyb.study.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author LiuYingBo 2021/01/30 21:42
 */
public class CachedThreadPool2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 100)
                .mapToObj(InterfacingTask::new)
                .forEach(executorService::execute);
        executorService.shutdown();


    }
}

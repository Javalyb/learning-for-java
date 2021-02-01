package priv.lyb.study.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author LiuYingBo 2021/01/30 22:04
 */
public class SingleThreadExecutor3 {
    public static void main(String [] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        IntStream.range(0,100)
                .mapToObj(InterfacingTask::new)
                .forEach(executorService::execute);
        executorService.shutdown();




    }
}

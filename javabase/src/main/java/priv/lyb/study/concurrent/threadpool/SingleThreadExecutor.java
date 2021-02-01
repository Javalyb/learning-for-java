package priv.lyb.study.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author LiuYingBo 2021/01/30 17:35
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0,100)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);
        System.out.println("All tasks submitted");
        exec.shutdown();
        while (!exec.isTerminated()){
            System.out.println(Thread.currentThread().getName()+" awaiting termination");
            //new Nap(0.1);
        }

    }
}

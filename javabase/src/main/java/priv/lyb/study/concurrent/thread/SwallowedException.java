package priv.lyb.study.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LiuYingBo 2021/01/31 17:00
 */
public class SwallowedException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(()->{
           throw new RuntimeException();
        });
        exec.shutdown();
    }
}

package priv.lyb.study.concurrent.thread;

import priv.lyb.study.concurrent.threadpool.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LiuYingBo 2021/01/31 16:32
 */
public class ThreadSize {
    static class Dummy extends Thread{
        @Override
        public void run() {
            new Nap(1);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int count = 0;
        try {
            while (true){
                executorService.execute(new Dummy());
                count++;
            }
        }catch (Error error){
            System.out.println(error.getClass().getSimpleName() + ":  "+count);
            System.exit(0);
        }finally {
            System.out.println("executorService.shutdown");
            executorService.shutdown();
        }

    }
}

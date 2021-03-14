package priv.lyb.study.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LiuYingBo 2021/01/31 17:10
 */
public class NativeExceptionHandling {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        try {
            es.execute(new ExceptionThread());
        }catch (RuntimeException e){
            System.out.println("Exception was handled");
        }finally {
            es.shutdown();
        }
    }
}

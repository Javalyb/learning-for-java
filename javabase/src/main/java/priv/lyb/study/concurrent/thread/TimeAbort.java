package priv.lyb.study.concurrent.thread;

import java.security.PublicKey;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYingBo 2021/01/31 20:12
 */
public class TimeAbort {
    private volatile boolean restart = true;

    public TimeAbort(double t, String msg){
        CompletableFuture.runAsync(()->{
            try {
                while(restart){
                    restart = false;
                    TimeUnit.MILLISECONDS.sleep((int)(1000*t));
                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(msg);
            System.exit(0);
        });

    }

    public TimeAbort(double t){
        this(t,"TimeAbort: " + t );
    }

    public void restart(){
        restart = true;
    }
}

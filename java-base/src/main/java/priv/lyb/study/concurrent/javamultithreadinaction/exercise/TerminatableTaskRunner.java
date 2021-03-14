package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiuYingBo 2021/02/05 01:49
 */
public class TerminatableTaskRunner {
    protected final BlockingQueue<Runnable> channel;
    protected volatile boolean inUse = true;
    public final AtomicInteger reservations = new AtomicInteger(0);
    private volatile WorkerThread workerThread;
    TerminatableTaskRunner(BlockingQueue<Runnable> channel){
        this.channel = channel;
        this.workerThread = new WorkerThread();
    }
    TerminatableTaskRunner(){
        this(new LinkedBlockingQueue<Runnable>());
    }
    public void init(){
        final Thread t = workerThread;
        if(t!=null){
            t.start();
        }
    }

    public void submit(Runnable target) throws InterruptedException {
        channel.put(target);
        reservations.incrementAndGet();
    }

    public void shutdown(){
        inUse = false;
        final Thread t = workerThread;
        if(t!=null){
            t.interrupt();
        }
    }

    class WorkerThread extends Thread{
        @Override
        public void run() {
            Runnable task;
            try {
                while(true){
                    if(!inUse && reservations.get()<=0){
                        break;
                    }
                    task = channel.take();
                    task.run();
                    reservations.decrementAndGet();
                }
            }catch (InterruptedException e){
                workerThread = null;
            }
        }
    }
}


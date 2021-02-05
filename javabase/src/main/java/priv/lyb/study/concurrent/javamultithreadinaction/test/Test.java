package priv.lyb.study.concurrent.javamultithreadinaction.test;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYingBo 2021/02/01 21:08
 */
class runnable implements Runnable{
    @Override
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName());
        }catch (Exception e){
        }
    }
}

class Callablees implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return 1;
    }
}

class Threades extends Thread{

}

public class Test {
    public static void main(String[] args){
        System.out.println("args: " + Arrays.toString(args));
        new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"thread-10").start();

        Thread thread1 = new Thread(new runnable(),"thread-20");
        thread1.start();

        Threades thread2 = new Threades();
        thread2.start();

        Thread thread3 = new Thread(new FutureTask<Integer>(new Callablees()));
        thread3.start();
        thread3.interrupt();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}

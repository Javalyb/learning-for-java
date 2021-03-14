package priv.lyb.study.concurrent.thread;

import priv.lyb.study.concurrent.threadpool.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * @author LiuYingBo 2021/02/01 03:36
 */
public class SerialNumberChecker implements Runnable{
    private CircularSet serials = new CircularSet(1000);
    private SerialNumbers producer;
    SerialNumberChecker(SerialNumbers producer){
        this.producer = producer;
    }
    @Override
    public void run() {
        while (true){
            int serial = producer.nextSerialNumber();
            if(serials.contains(serial)){
                System.out.println("Duplicate: "+ serial);
                System.exit(0);
            }
            serials.add(serial);
        }
    }

    static void test(SerialNumbers producer){
        for (int i = 0; i < 10; i++) {
            CompletableFuture.runAsync(new SerialNumberChecker(producer));
        }
        new Nap(4,"No duplicates detected");
    }
}

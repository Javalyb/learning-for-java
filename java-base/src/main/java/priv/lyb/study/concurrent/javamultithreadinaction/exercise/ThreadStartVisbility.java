package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

import java.util.concurrent.TimeUnit;

/**
 * @author LiuYingBo 2021/02/03 06:14
 */
public class ThreadStartVisbility {
    static int data = 0;
    //可能为1，可能为2
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
                System.out.println(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        data = 1;
        thread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data = 2;
    }
}

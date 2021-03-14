package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

/**
 * @author LiuYingBo 2021/02/03 06:38
 */
public class ThreadJoinVisbility {
    static int data = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            data = 1;
        });
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(data);
    }
}

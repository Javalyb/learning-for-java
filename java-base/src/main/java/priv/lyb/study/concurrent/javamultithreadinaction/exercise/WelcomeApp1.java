package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

/**
 * @author LiuYingBo 2021/02/01 22:48
 */

public class WelcomeApp1 {
    public static void main(String[] args) {
        Thread welcomeThread = new Thread(new WelcomeTask());
        welcomeThread.start();
        System.out.println("1.Welcome!I'm " + Thread.currentThread().getName());
    }
}

class WelcomeTask implements Runnable {
    @Override
    public void run() {
        System.out.println("2.Welcome!I'm " + Thread.currentThread().getName());
    }
}

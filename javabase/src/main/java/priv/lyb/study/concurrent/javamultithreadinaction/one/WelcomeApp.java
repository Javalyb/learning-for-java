package priv.lyb.study.concurrent.javamultithreadinaction.one;

/**
 * @author LiuYingBo 2021/02/01 22:35
 */
class WelcomeThread extends Thread {
    @Override
    public void run() {
        System.out.println("2.Welcome!I'm " + Thread.currentThread().getName());
    }
}

public class WelcomeApp {
    public static void main(String[] args) {
        Thread welcomeThread = new WelcomeThread();
        welcomeThread.start();
        System.out.println("1.Welcome!I'm " + Thread.currentThread().getName());
    }
}

package priv.lyb.study.concurrent.javamultithreadinaction.one;

/**
 * @author LiuYingBo 2021/02/02 04:04
 */
public class JavaThreadAnywhere {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        String currentThreadName = currentThread.getName();
        System.out.println("main currentThreadName: " + currentThreadName);
        Helper helper = new Helper("Java Thread AnyWhere");
        helper.run();
    }

    static class Helper implements Runnable {
        private final String message;

        Helper(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            doSomething(message);
        }

        void doSomething(String message) {
            Thread currentThread = Thread.currentThread();
            String currentThreadName = currentThread.getName();
            System.out.println("HelperThreadName: " + currentThreadName);
            System.out.println("Helper message: " + message);
        }
    }
}

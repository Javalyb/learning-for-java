package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

import java.util.SplittableRandom;

/**
 * @author LiuYingBo 2021/02/02 19:51
 */
public class RaceConditionDemo {

    public static void main(String[] args) {
        SplittableRandom rand = new SplittableRandom(47);
        Thread[] workerThread = new Thread[4];
        int requestCount = 4;
        for (int i = 0; i < workerThread.length; i++) {
            workerThread[i] = new WorkerThread(i, requestCount);
        }

        for (Thread thread : workerThread) {
            thread.start();
        }
    }


    static class WorkerThread extends Thread {
        private final int requestCount;

        WorkerThread(int id, int requestCount) {
//            super("Worker-" + id);
            this.requestCount = requestCount;
        }

        @Override
        public void run() {
            int i = requestCount;
            String requestId;
            RequestIdGenerator requestIdGen = RequestIdGenerator.getInstance();
            while (i-- > 0) {
                requestId = requestIdGen.nextID();
                processRequest(requestId);
            }
        }

        void processRequest(String requestId) {
            System.out.println(Thread.currentThread().getName() + " Got requestId: " + requestId);
        }
    }
}

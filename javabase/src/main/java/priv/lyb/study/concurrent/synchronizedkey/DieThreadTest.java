package priv.lyb.study.concurrent.synchronizedkey;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author Liuyingbo 2020/12/30
 */
@Slf4j
public class DieThreadTest {
    static Object obj1 = new Object();
    static Object obj2 = new Object();

    @Test
    public void fun1() {
        log.info("---");
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

    class Thread1 implements Runnable {
        @Override
        public void run() {
            log.info("Thread1 is run");
            synchronized (DieThreadTest.obj1) {
                try {
                    log.info("Thread1 lock obj1");
                    Thread.sleep(3000);
                    synchronized (DieThreadTest.obj2) {
                        log.info("Thread1 lock obj2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("---end Thread1---");
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            log.info("Thread2 is run");
            synchronized (DieThreadTest.obj1) {
                try {
                    log.info("Thread2 lock obj2");
                    Thread.sleep(3000);
                    synchronized (DieThreadTest.obj2) {
                        log.info("Thread2 lock oj1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("---end Thread2---");
            }
        }
    }
}

package priv.lyb.study.concurrent.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @author LiuYingBo 2021/01/31 23:59
 */
public class Atomicity {
    public static void test(IntTestable it) {
        new TimeAbort(4, "");
        CompletableFuture.runAsync(it);
        while (true) {
            int val = it.getAsInt();
            if (val % 2 != 0) {
                System.out.println("failed with:" + val);
                System.exit(0);
            }
        }
    }
}

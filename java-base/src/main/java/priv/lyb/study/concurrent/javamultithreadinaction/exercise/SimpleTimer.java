package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

import java.util.Arrays;
import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYingBo 2021/02/02 03:26
 */
public class SimpleTimer {
    private static int count;
    private static SplittableRandom rand = new SplittableRandom();

    public static void main(String[] args) {
        args = new String[rand.nextInt(100)];
        Arrays.fill(args, String.valueOf(rand.nextInt(100,300)));
        count = args.length > 0 ? Integer.valueOf(args[0]) : rand.nextInt(100,300);
        int remaining;
        while (true) {
            remaining = countDown();
            if (remaining == 0) {
                break;
            } else {
                System.out.println("Remaining" + count + " second(s)");
            }
        }

//        try {
//            System.out.println("sleep");
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    static int countDown() {
        return count--;
    }
}

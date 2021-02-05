package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.SplittableRandom;

/**
 * @author LiuYingBo 2021/02/03 04:30
 */
public class NonAtomicAssignmentDemo implements Runnable {
    private volatile static long value = 0;
    final long valueToSet;
    private static SplittableRandom rand = new SplittableRandom();

    NonAtomicAssignmentDemo(long valueToSet) {
        this.valueToSet = valueToSet;
    }

    public static void main(String[] args) {
        NonAtomicAssignmentDemo nonAtomicLong1 = new NonAtomicAssignmentDemo(rand.nextInt(0,5));
        NonAtomicAssignmentDemo nonAtomicLong2 = new NonAtomicAssignmentDemo(rand.nextInt(5,9));

        PrintStream ps = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        });

        new Thread(nonAtomicLong1).start();
        new Thread(nonAtomicLong2).start();

        long snapshot;
        int i = 0;
        while ((snapshot = value) == 0) {
            i++;
            ps.println(snapshot);
        }
        System.out.println("snapshot1: " + snapshot + " " + i);
        ps.close();
    }

    @Override
    public void run() {
        value = valueToSet;
    }
}

package priv.lyb.study.concurrent.thread;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author LiuYingBo 2021/01/31 18:09
 */
@SuppressWarnings("unchecked")
public class EvenChecker implements Runnable {
    private final int id;
    private IntGenerator generator;

    EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }

    public static void test(IntGenerator gp, int count) {
        List<CompletableFuture<Void>> checkers = IntStream.range(0, 100)
                .mapToObj(i -> new EvenChecker(gp, i))
                .map(CompletableFuture::runAsync)
                .collect(Collectors.toList());
        checkers.forEach(CompletableFuture::join);
    }


    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
            }
            generator.cancel();
        }
    }

}

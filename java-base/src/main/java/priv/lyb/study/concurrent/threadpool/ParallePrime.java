package priv.lyb.study.concurrent.threadpool;

import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/30 16:42
 */
public class ParallePrime {
    private static final int COUNT = 100000;
    public static boolean isPrime(long n){
        return true;
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        List<String> primes = Stream.iterate(2, i->i+1)
                .parallel()
                .filter(ParallePrime::isPrime)
                .limit(COUNT)
                .map(s->String.valueOf(s))
                .collect(Collectors.toList());
        System.out.println(timer.purge());

    }
}

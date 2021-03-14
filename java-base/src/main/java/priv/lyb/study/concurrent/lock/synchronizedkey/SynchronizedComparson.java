package priv.lyb.study.concurrent.lock.synchronizedkey;

import priv.lyb.study.concurrent.threadpool.Nap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/02/01 04:14
 */

abstract class Guarded {
    AtomicLong callCount = new AtomicLong();

    public abstract void method();

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + callCount;
    }
}

class SynchronizedMethod extends Guarded {
    @Override
    public synchronized void method() {
        new Nap(0.01);
        callCount.getAndIncrement();
    }
}

class CriticalSection extends Guarded {
    @Override
    public void method() {
        new Nap(0.01);
        synchronized (this) {
            callCount.getAndIncrement();
        }
    }
}

class Caller implements Runnable {
    private Guarded g;
    private AtomicLong successFulCalls = new AtomicLong();
    private AtomicBoolean stop = new AtomicBoolean(false);

    Caller(Guarded g) {
        this.g = g;
    }

    @Override
    public void run() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                stop.set(true);
            }
        }, 2500);
        while (!stop.get()) {
            g.method();
            successFulCalls.getAndIncrement();
        }
        System.out.println("->" + successFulCalls.get());
    }
}

@SuppressWarnings("unchecked")
public class SynchronizedComparson {
    static void test(Guarded g) {
        List<CompletableFuture<Void>> callers = Stream.of(new Caller(g), new Caller(g), new Caller(g), new Caller(g))
                .map(CompletableFuture::runAsync)
                .collect(Collectors.toList());
        callers.forEach(CompletableFuture::join);
        System.out.println(g);
    }

    public static void main(String[] args) {
        test(new CriticalSection());
        test(new SynchronizedMethod());
    }

}

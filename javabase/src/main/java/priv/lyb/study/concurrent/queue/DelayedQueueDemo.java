package priv.lyb.study.concurrent.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/02/01 05:29
 */
class DelayedTask implements Runnable, Delayed {
    protected static List<DelayedTask> sequence = new ArrayList<>();
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;

    DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MICROSECONDS);
        sequence.add(this);
    }


    @Override
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask) arg;
        if (trigger < that.trigger) {
            return -1;
        }
        if (trigger > that.trigger) {
            return 1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public void run() {
        System.out.println("this" + " ");
    }

    public String summary() {
        return "id: " + id+"delta: " +delta;
    }

    public static class EndClass extends DelayedTask {
        EndClass(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            sequence.forEach(dt -> {
                System.out.println(dt.summary());
            });
        }
    }
}

public class DelayedQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedTask> tasks = Stream.concat(
                new Random(47).ints(20, 0, 4000).mapToObj(DelayedTask::new),
                Stream.of(new DelayedTask.EndClass(4000))
        ).collect(Collectors.toCollection(DelayQueue::new));
        while (tasks.size()>0){
            tasks.take().run();
        }
    }
}

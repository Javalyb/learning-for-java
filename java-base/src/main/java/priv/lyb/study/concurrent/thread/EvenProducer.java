package priv.lyb.study.concurrent.thread;

/**
 * @author LiuYingBo 2021/01/31 21:09
 */
public class EvenProducer extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenProducer());
    }
}

package priv.lyb.study.concurrent.tools;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 19:40 2021/02/22
 */
public class ExchangerTest {
    static Exchanger<Set<String>> exchanger = new Exchanger<>();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            set.add("e1");
            set.add("e2");
            set.add("e3");
            main(set);
        });

        Thread t2 = new Thread(() -> {
            set.add("e4");
            set.add("e5");
            main(set);
        });

        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    static void main(Set<String> set) {
        System.out.println(Thread.currentThread().getName() + " 交换前的值");
        for (String s : set) {
            System.out.println(s);
        }
        try {
            set = exchanger.exchange(set);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 交换后的值");
        for (String s : set) {
            System.out.println(s);
        }
    }
}

package priv.lyb.designpattern.creational.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Liuyingbo 2021/1/2
 */
@Slf4j
public class SingletonTest {
    private SingletonTest() {
    }

    private volatile static SingletonTest singletonTest = null;

    public static SingletonTest getSingletonTest() {
        if (singletonTest == null) {
            synchronized (SingletonTest.class) {
                if (singletonTest == null) {
                    singletonTest = new SingletonTest();
                }
            }
        }
        return singletonTest;
    }
}

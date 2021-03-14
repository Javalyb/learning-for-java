package priv.lyb.study.designpattern.creational.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author Liuyingbo 2021/1/2
 */
@Slf4j
public class SingletonRun {
    @Test
    public void fun1() {
        log.info("{}", SingletonTest.getSingletonTest());
        log.info("{}", SingletonTest.getSingletonTest());
    }
}

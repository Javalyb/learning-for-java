package priv.lyb.study.package2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author LiuYingBo 2021/1/5 上午11:09
 */
@Slf4j
public class A {
    @Test
    public void fun1() {
        int i = 1;
        int j = ++i;
        System.out.println(j);
        System.out.println(i);
    }

    @Test
    public void fun2() {
        int i = 1;
        int j = i++;
        System.out.println(j);
        System.out.println(i);
    }
}

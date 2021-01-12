package priv.lyb.study.base.operator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author LiuYingBo 2021/1/5 上午11:09
 */


/**
 * ++赋值操作：
 * 1.j = ++i(1：i=i+1；2：j=i；)：++在前，i先加1，再赋值给j；
 * 2.j = i++(1：j=i；2：i=i+1；)：++在后，先赋值给j，再i加1；
 * 3.单独的i++和++i，没有区别；
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

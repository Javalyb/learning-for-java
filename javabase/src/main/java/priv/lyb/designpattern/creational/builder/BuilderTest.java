package priv.lyb.designpattern.creational.builder;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Liuyingbo 2021/1/2
 * 批量创建多个对象
 */
@Slf4j
public class BuilderTest {
    @Test
    public void fun1() {
        Builder builder = new Builder();
        log.info("{}", builder.provideRandonNumber1(5).toString());
        Builder builder1 = new Builder();
        log.info("{}", builder1.provideRandonNumber1(10).toString());
    }
}

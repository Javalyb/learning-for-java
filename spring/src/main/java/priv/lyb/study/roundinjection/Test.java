package priv.lyb.study.roundinjection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author LiuYingBo 2021/1/3 下午10:48
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void fun() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(A.class);
        builder.build();


    }
}

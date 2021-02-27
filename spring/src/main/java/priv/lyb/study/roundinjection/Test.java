package priv.lyb.study.roundinjection;

import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author LiuYingBo 2021/1/3 下午10:48
 */
public class Test {
    public void fun() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(A.class);
        builder.build();
    }
}

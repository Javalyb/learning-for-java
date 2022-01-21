package priv.lyb.antiduplication;

import java.lang.annotation.*;

/**
 * @Author: lyb
 * @Description:
 * @Date: 19:44 2022/01/04
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PreventDuplication {

    //反重复提交限时标记数字（存储redis限时标记数值）
    String value() default "value";

    //反重复操作过期时间（借助redis实现限时控制）
    long expriceSeconds() default 10;

}

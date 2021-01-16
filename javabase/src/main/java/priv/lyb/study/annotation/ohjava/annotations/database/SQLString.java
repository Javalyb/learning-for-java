package priv.lyb.study.annotation.ohjava.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author LiuYingBo 2021/01/15 14:35
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    int id() default 0;
    String name() default "";
    Constraints constraints() default @Constraints;
}

package priv.lyb.study.jdk8new.localdatetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author LiuYingBo 2021/01/11 17:09
 */
public class Test {
    public void fun() {
        //日期->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String timeFormat = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timeFormat);

        //字符串->日期
        LocalDateTime localDateTime1 = LocalDateTime.parse("2020-01-01 23:10:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDateTime1);

        //数字->日期
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 1, 11, 17, 31, 40);
        System.out.println(localDateTime2);


    }

    public static void main(String[] args) {
        //日期->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String timeFormat = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timeFormat);
    }

}

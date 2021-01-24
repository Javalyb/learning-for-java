package priv.lyb.study.codeverification.junit5;

import jdk.nashorn.internal.AssertsEnabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author LiuYingBo 2021/01/25 01:14
 */
public class CountedListTest {
    private CountedList countedList;

    @BeforeAll
    public static void beforeAllMsg(){
        System.out.println(">>> Starting CountedListTest");
    }

    @Test
    public void insert(){
        System.out.println("Running testInsert");

    }

}

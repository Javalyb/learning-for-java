package priv.lyb.study.codeverification.junit5;

import org.junit.jupiter.api.*;

/**
 * @author LiuYingBo 2021/01/25 01:14
 */
public class CountedListTest {
    private CountedList list;

    @BeforeAll
    public static void beforeAllMsg(){
        System.out.println(">>> Starting CountedListTest");
    }

    @AfterAll
    public static void afterallMsg(){
        System.out.println(">>> Finished CountedListTest");
    }

    @BeforeEach
    public void initialize(){
        list = new CountedList();
        System.out.println("Set up for " + list.getId());
        for (int i=0;i<3;i++)
            list.add(Integer.toString(i));
    }

    @AfterEach
    public void cleanup(){
        System.out.println("Cleaning up "+list.getId());
    }

    @Test
    public void insert(){
        System.out.println("Running testInsert");
    }

}

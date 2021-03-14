package priv.lyb.study.codeverification.junit5;

import java.util.ArrayList;

/**
 * @author LiuYingBo 2021/01/25 01:13
 */
public class CountedList extends ArrayList<String> {
    private static int counter = 0;
    private int id = counter ++;
    CountedList(){
        System.out.println("CountedList #" + id);
    }
    int getId(){
        return id;
    }
}

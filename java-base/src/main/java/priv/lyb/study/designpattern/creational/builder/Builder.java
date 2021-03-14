package priv.lyb.study.designpattern.creational.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Liuyingbo 2021/1/2
 */
public class Builder {
    private List<Integer> list = new ArrayList<Integer>();

    public List<Integer> provideRandonNumber1(int number) {
        for (int i = 0; i < number; i++) {
            list.add(new Random().nextInt());
        }
        return list;
    }

    public List<Integer> provideRandonNumber2(int number) {
        for (int i = 0; i < number; i++) {
            list.add(new Random().nextInt());
        }
        return list;
    }
}

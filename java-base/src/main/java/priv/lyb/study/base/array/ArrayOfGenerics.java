package priv.lyb.study.base.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/27 23:28
 */
public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la;
        ls[0] = new ArrayList<>();

        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();

    }
}

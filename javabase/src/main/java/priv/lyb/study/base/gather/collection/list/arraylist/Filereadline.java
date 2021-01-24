package priv.lyb.study.base.gather.collection.list.arraylist;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/21 22:20
 */
public class Filereadline {
    @Test
    public void fun() throws IOException {
        List<String> list = Files.readAllLines(Paths.get("/Users/liuyingbo/idea/LearningProcessForJava/javabase/src/main/java/priv/lyb/study/base/collection/arraylist/Filereadline.java"));
        for (String s : list) {
            System.out.println(s);
        }
    }
}

package priv.lyb.study.base.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author LiuYingBo 2021/01/25 21:20
 */
public class ListOfLines {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("/Users/liuyingbo/idea/LearningProcessForJava/javabase/src/main/java/priv/lyb/study/base/io/ListOfLines.java"))
                .stream()
                .filter(line -> !line.startsWith("//"))
//                .map(line -> line.substring(0,line.length()/2))
                .forEach(System.out::println);
    }
}

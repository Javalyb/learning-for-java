package priv.lyb.study.base.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author LiuYingBo 2021/01/25 21:52
 */
public class ReadLineStream {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("/Users/liuyingbo/idea/LearningProcessForJava/test/test.txt"), Charset.defaultCharset())
            .forEach(System.out::println);



        Files.lines(Paths.get("/Users/liuyingbo/idea/LearningProcessForJava/test/test.txt"), Charset.defaultCharset())
            .skip(1)
            .findFirst()
            .ifPresent(System.out::println);
    }
}

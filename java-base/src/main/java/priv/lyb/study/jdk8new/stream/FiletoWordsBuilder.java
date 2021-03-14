package priv.lyb.study.jdk8new.stream;

import sun.applet.Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/23 16:14
 */
public class FiletoWordsBuilder {
    private FiletoWordsBuilder(){}

    static Stream.Builder<String> builder = Stream.builder();

    static Stream.Builder<String> readWords(String path) throws IOException {
        Files.lines(Paths.get(path))
                .forEach(line -> {
                   builder.add(line);
                });
        return builder;
    }
    public static void main(String[] args) throws Exception{
            FiletoWordsBuilder.readWords("/Users/liuyingbo/idea/LearningProcessForJava/javabase/src/main/java/priv/lyb/study/jdk8new/stream/FiletoWordsBuilder.java")
                    .build()
                    .limit(100)
                    .forEach(System.out::println);


    }
}

package priv.lyb.study.jdk8new.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/23 19:20
 */
public class FiletoWordsRegexp {
    private String content;

    public FiletoWordsRegexp(){}

    public FiletoWordsRegexp(String path) throws IOException {
        this.content = Files.lines(Paths.get(path)).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws Exception {
        FiletoWordsRegexp filetoWordsRegexp = new FiletoWordsRegexp("/Users/liuyingbo/idea/LearningProcessForJava/javabase/src/main/java/priv/lyb/study/jdk8new/stream/FiletoWordsRegexp.java");
        filetoWordsRegexp.stream()
                .limit(7)
                .map(m -> m + "")
                .forEach(System.out::println);
        System.out.println();
        filetoWordsRegexp.stream()
                .limit(7)
                .map(m -> m + "")
                .forEach(System.out::println);

    }

    Stream<String> stream() {
        return Pattern.compile("[ .,?]+").splitAsStream(content);
    }

}

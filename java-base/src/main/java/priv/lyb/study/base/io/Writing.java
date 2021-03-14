package priv.lyb.study.base.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

/**
 * @author LiuYingBo 2021/01/25 21:28
 */
public class Writing {
    static Random random = new Random(47);
    static final int SIZE = 1000;
    static Path path = Paths.get("/Users/liuyingbo/idea/LearningProcessForJava/test/dir.tmp");
    static Path test = Paths.get("test");
    static Path path1 = Paths.get("/Users/liuyingbo/idea/LearningProcessForJava/test/test1.txt");
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[SIZE];
        random.nextBytes(bytes);
        Files.write(path,bytes);
        System.out.println("文件大小: "+ Files.size(path));

        Files.deleteIfExists(test.resolve("test.txt"));
        Files.createFile(test.resolve("test.txt"));
        test = test.resolve("test.txt");

        System.out.println(test.toRealPath());
        Files.write(test,bytes);
        System.out.println(Files.size(test));

        Files.deleteIfExists(path1);
        Files.createFile(path1);
        Files.write(path1, Arrays.asList("123","456","789"));
    }
}

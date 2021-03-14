package priv.lyb.study.base.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/25 18:01
 */
public class Directories {
    static Path test = Paths.get("test");
    //获取当前符盘
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }

    static void refreshTestDir() throws IOException {
        if (Files.exists(test)) {
            RmDir.fmdir(test);
        }
        if (!Files.exists(test)) {
            Files.createDirectory(test);
        }
    }

    static void populateTestDir() throws IOException {
        for (int i = 0; i < parts.size(); i++) {
            Path path = makeVariant();
            if (!Files.exists(path)) {
                Files.createDirectories(path);
                Files.copy(Paths.get("/Users/liuyingbo/idea/LearningProcessForJava/javabase/src/main/java/priv/lyb/study/base/io/Directories.java"),
                        path.resolve("file.ext"));
//                Files.createTempDirectory(path, null, null);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();
        try {
            Files.createDirectory(variant);
        } catch (Exception e) {
            System.out.println("Nope, that doesn't work.");
        }
        populateTestDir();
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println(test.toRealPath());
        Files.walk(test).forEach(System.out::println);

    }

    @Test
    public void fun() {
        Collections.rotate(parts, 1);
        System.out.println(Paths.get("test", String.join(sep, parts)));
    }
}

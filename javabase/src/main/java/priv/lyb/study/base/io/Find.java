package priv.lyb.study.base.io;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author LiuYingBo 2021/01/25 20:54
 */
public class Find {
    public static void main(String[] args) throws IOException {
        Path test = Paths.get("test");
        Files.deleteIfExists(test.resolve("dir1.tmp"));
        Files.deleteIfExists(test.resolve("dir2.tmp"));
        Files.createFile(test.resolve("dir1.tmp"));
        Files.createFile(test.resolve("dir2.tmp"));

        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.{tmp,txt}");
        Files.walk(test)
                .filter(pathMatcher::matches)
                .forEach(System.out::println);

    }
}

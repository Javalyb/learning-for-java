package priv.lyb.study.base.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author LiuYingBo 2021/01/25 16:04
 */
public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.print(" " + id + " : ");
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        Path path1 = Paths.get("PathAnalysis.java").toAbsolutePath();
        Path path2 = Paths.get("/Users/liuyingbo/idea/LearningProcessForJava/javabase/src/main/java/priv/lyb/study/base/io/PathAnalysis.java");
        say("absolutePath Exists", Files.exists(path1));
        say("Exists", Files.exists(path2));
        say("absolutePath Dirctory", Files.isDirectory(path1));
        say("absolutePath Executable", Files.isExecutable(path1));
        say("absolutePath Executable", Files.isExecutable(path2));
        say("Readable",Files.isReadable(path1));
        say("Writeable",Files.isWritable(path1));
        say("Writeable",Files.isWritable(path2));
        say("Hidden",Files.isHidden(path1));
        say("Hidden",Files.isHidden(path2));
        say("size",Files.size(path2));
        say("fileStore",Files.getFileStore(path2));
        say("getLastModifiedTime",Files.getLastModifiedTime(path2));
        say("getOwner",Files.getOwner(path2));
        say("probeContentType",Files.probeContentType(path2));
        say("isSymbolicLink",Files.isSymbolicLink(path2));

    }
}

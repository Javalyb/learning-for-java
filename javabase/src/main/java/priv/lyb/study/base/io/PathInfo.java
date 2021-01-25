package priv.lyb.study.base.io;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author LiuYingBo 2021/01/25 14:51
 */
public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    static void info(Path p) {
        show("toString", p);
        show("Exists", Files.exists(p));
        show("Regularfile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("---------------------------------------------------------");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("/Users/liuyingbo/Documents/desk_backup/crm.txt"));
        Path path = Paths.get("srm.txt");
        info(path);
        Path abPath = path.toAbsolutePath();
        info(abPath);
        info(abPath.getParent());
        try {
            info(path.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
        URI uri = path.toUri();
        System.out.println("URI:" + uri);
        System.out.println(Files.exists(Paths.get(uri)));
    }
}

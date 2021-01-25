package priv.lyb.study.base.io;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author LiuYingBo 2021/01/25 15:44
 */
public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PartsOfPaths.java").toAbsolutePath();
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }
        System.out.println("ends with .java: " + p.endsWith(".java"));
        for (Path path : p) {
            System.out.print(path+": ");
            System.out.print(p.startsWith(path) + ": ");
            System.out.print(p.endsWith(path));
        }
        System.out.println();
        System.out.println("Starts with "+p.getRoot()+" "+ p.startsWith(p.getRoot()));
    }
}

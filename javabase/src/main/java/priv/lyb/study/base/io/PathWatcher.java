package priv.lyb.study.base.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * @author LiuYingBo 2021/01/25 20:04
 */
public class PathWatcher {
    static Path test = Paths.get("test");

    static void delTxtFiles() {
        try {
            Files.walk(test).filter(s -> s.toString().endsWith(".txt"))
                    .forEach(f -> {
                        try {
                            Files.delete(f);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Files.createFile(test.resolve("Hello1.txt"));
        WatchService watchService = FileSystems.getDefault().newWatchService();
        test.register(watchService,ENTRY_DELETE);
        Executors.newSingleThreadScheduledExecutor().schedule(PathWatcher::delTxtFiles,250, TimeUnit.MILLISECONDS);
        WatchKey key = watchService.take();
        for (WatchEvent<?> pollEvent : key.pollEvents()) {
            System.out.println("context "+pollEvent.context()+" count "+pollEvent.count()+" kind "+pollEvent.kind());
            System.exit(0);
        }
    }
}

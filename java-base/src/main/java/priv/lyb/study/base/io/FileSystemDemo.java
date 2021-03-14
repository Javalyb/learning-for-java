package priv.lyb.study.base.io;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author LiuYingBo 2021/01/25 19:43
 */
public class FileSystemDemo {
    static void show(String id, Object o) {
        System.out.println(id + " : " + o);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        FileSystem fileSystem = FileSystems.getDefault();
        for (FileStore fileStore : fileSystem.getFileStores()) {
            show("FileStore", fileStore);
        }

        for (Path rootDirectory : fileSystem.getRootDirectories()) {
            show("getRootDirectories", rootDirectory);
        }

        show("getSeparator", fileSystem.getSeparator());
        show("getUserPrincipalLookupService", fileSystem.getUserPrincipalLookupService());
        show("isOpen", fileSystem.isOpen());
        show("isReadOnly", fileSystem.isReadOnly());
        show("provider", fileSystem.provider());
        show("supportedFileAttributeViews", fileSystem.supportedFileAttributeViews());
    }
}

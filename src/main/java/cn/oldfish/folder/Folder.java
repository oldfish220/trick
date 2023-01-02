package cn.oldfish.folder;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class Folder {
    // 遍历所有文件
    public static void traversalFiles(String path) throws IOException {
        try(Stream<Path> pathStream = Files.walk(Paths.get(path))) {
            pathStream.filter(Files::isRegularFile).forEach(System.out::println);
        }
    }

    // 寻找所有包含单词"gender"的java文件
    public static void filterFile(String path) throws IOException {
        Files.walkFileTree(
                Paths.get(path),
                new FileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        if (file.toString().endsWith(".java")) {
                            String content = Files.readString(file);
                            if (content.contains("gender")) {
                                System.out.println(file);
                            }
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        return FileVisitResult.CONTINUE;
                    }
                }
        );
    }
}

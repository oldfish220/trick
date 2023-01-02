package cn.oldfish.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class File {
    public static Map<String, Object> readFile(String path) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(path));
        return lines.collect(Collectors.toMap(line ->
                line.split("=")[0],
                line -> line.split("=")[1], (a, b) -> b)
        );
    }
}

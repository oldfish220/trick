package cn.oldfish.file;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class FileTest {
    @Test
    public void readerFileTest() throws IOException {
        Map<String, Object> map = File.readFile("src/main/resources/file/config.properties");
        System.out.println(map);
    }
}

package cn.oldfish.folder;

import org.junit.Test;

import java.io.IOException;

public class FolderTest {
    @Test
    public void traversalTest() throws IOException {
        Folder.traversalFiles("src");
    }

    @Test
    public void filterFileTest() throws IOException {
        Folder.filterFile("src");
    }
}

package cn.oldfish.stream.sort;

import org.junit.Test;

public class SortTest {
    @Test
    public void comparableSortTest() {
        Sorter.comparableSort();
    }

    @Test
    public void sortByAgeTest() {
        System.out.println(Sorter.sortByAge());
    }

    @Test
    public void sortByGenderAndAgeTest() {
        System.out.println(Sorter.sortByGenderAndAge());
    }

    @Test
    public void sortByAgeAndReverseTest() {
        System.out.println(Sorter.sortByAgeAndReverse());
    }
}

package cn.oldfish.stream.filter;

import org.junit.Test;

public class FilterTest {
    @Test
    public void filterByAgeTest() {
        System.out.println(Filter.filterByAge());
    }

    @Test
    public void filterByRowTest() {
        System.out.println(Filter.filterByRow());
    }

    @Test
    public void filterByConditionFirstTest() {
        System.out.println(Filter.filterByConditionFirst());
    }

    @Test
    public void matchByAgeTest() {
        System.out.println(Filter.matchByAge());
    }

    @Test
    public void filterByConditionRetainTest() {
        System.out.println(Filter.filterByConditionRetain());
    }
}

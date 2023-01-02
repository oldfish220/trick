package cn.oldfish.stream.grouping;

import cn.oldfish.stream.grouping.bean.User;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class GroupingTest {
    @Test
    public void groupByGenderTest() {
        Map<Integer, List<User>> groupByGender = Grouper.groupByGender();
        groupByGender.forEach((gender, users) -> {
            System.out.println("gender: " + gender);
            System.out.println("users: " + users);
        });
    }

    @Test
    public void groupByAgeTest() {
        Map<String, List<User>> groupByAge = Grouper.groupByAge();
        groupByAge.forEach((age, users) -> {
            System.out.println("age: " + age);
            System.out.println("users: " + users);
        });
    }

    @Test
    public void groupAndCountByGender1Test() {
        Map<Integer, Long> groupAndCountByGender1 = Grouper.groupAndCountByGender1();
        groupAndCountByGender1.forEach((age, counter) -> {
            System.out.println("age: " + age);
            System.out.println("counter: " + counter);
        });
    }

    @Test
    public void groupAndCountByGender2Test() {
        Map<Integer, Long> groupAndCountByGender2 = Grouper.groupAndCountByGender2();
        groupAndCountByGender2.forEach((age, counter) -> {
            System.out.println("age: " + age);
            System.out.println("counter: " + counter);
        });
    }
}

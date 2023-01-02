package cn.oldfish.stream.sort;

import cn.oldfish.stream.sort.bean.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("张三", 18, 1));
        users.add(new User("李四", 23, 0));
        users.add(new User("王五", 20, 1));
        users.add(new User("赵六", 28, 0));
        users.add(new User("田七", 26, 1));
        users.add(new User("孙八", 31, 0));
        users.add(new User("周九", 27, 1));
        users.add(new User("吴十", 22, 0));
    }

    // Comparable借口，可以让类直接实现该借口并自定义排序方法，某些类已经实现了该借口，能直接使用排序
    public static void comparableSort() {
        List<Integer> list = new ArrayList<>(List.of(2, 5, 4, 6, 7, 3, 1, 9, 8));
        Collections.sort(list);
        System.out.println(list);
    }

    public static List<User> sortByAge() {
        Comparator<User> comparator = Comparator.comparing(User::getAge);
        users.sort(comparator);
        return users;
    }

    public static List<User> sortByGenderAndAge() {
        Comparator<User> comparator = Comparator.comparing(User::getGender).thenComparing(User::getAge);
        users.sort(comparator);
        return users;
    }

    public static List<User> sortByAgeAndReverse() {
        Comparator<User> comparator = Comparator.comparing(User::getAge).reversed();
        users.sort(comparator);
        return users;
    }
}

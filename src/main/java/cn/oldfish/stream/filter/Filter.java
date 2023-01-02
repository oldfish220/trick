package cn.oldfish.stream.filter;

import cn.oldfish.stream.filter.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
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

    // 按条件过滤，取出年龄在25岁以下的用户
    public static List<User> filterByAge() {
        return users.stream().filter(u -> u.getAge() < 25).collect(Collectors.toList());
    }

    // 跳过前五条数据之后，保留前三条数据
    public static List<User> filterByRow() {
        return users.stream().skip(5).limit(3).collect(Collectors.toList());
    }

    // 寻找符合条件的第一项
    public static User filterByConditionFirst() {
        return users.stream().filter(u -> u.getName().startsWith("王")).findFirst().orElse(null);
    }

    // 判断是否有符合条件的数据(是否都符合、是否都不符合)
    public static boolean matchByAge() {
        return users.stream().allMatch(u -> u.getAge() < 30);
    }

    // 保留第一个不合法数据前面的所有数据
    // taskWile和dropWhile是JDK9新增的API
    public static List<User> filterByConditionRetain() {
        return users.stream().takeWhile(u -> u.getAge() < 29).collect(Collectors.toList());
    }
}

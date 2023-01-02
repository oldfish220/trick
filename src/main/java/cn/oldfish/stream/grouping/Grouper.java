package cn.oldfish.stream.grouping;

import cn.oldfish.stream.grouping.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouper {
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

    // 根据性别分组
    public static Map<Integer, List<User>> groupByGender() {
        return users.stream().collect(Collectors.groupingBy(User::getGender));
    }

    // 根据年龄分组
    public static Map<String, List<User>> groupByAge() {
        return users.stream().collect(Collectors.groupingBy(user -> {
            int age = user.getAge();
            if (age >= 18 && age < 21) {
                return "18-20";
            } else if (age >= 21 && age < 24) {
                return "21-23";
            } else if (age >= 24 && age < 27) {
                return "24-26";
            } else {
                return "其他";
            }
        }));
    }

    // 统计每种性别人数1
    public static Map<Integer, Long> groupAndCountByGender1() {
        return users.stream().collect(Collectors.groupingBy(User::getGender, Collectors.counting()));
    }

    // 统计每种性别人数2
    // 参数一：初始值
    // 参数二：每个数据怎么合并到初始值中
    // 参数三：怎么把两个结果集数据合并到一起
    public static Map<Integer, Long> groupAndCountByGender2() {
        return users.stream().reduce(
                new HashMap<>(),
                (map, user) -> {
                    map.put(user.getGender(), map.getOrDefault(user.getGender(), 0L) + 1);
                    return map;
                },
                (m1, m2) -> {
                    m1.putAll(m2);
                    return m1;
                }
        );
    }
}

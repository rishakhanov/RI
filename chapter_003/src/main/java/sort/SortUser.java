package sort;

import java.util.*;
import java.util.stream.Collectors;

public class SortUser {

    public Set<User> sort(List<User> list) {
        Set<User> users = new TreeSet<>();
        users.addAll(list);
        return users;
    }

    public List<User> sortNameLength(List<User> list) {
        List<User> sortedList = list.stream().sorted(Comparator.comparing(User::getNameLength)).
                collect(Collectors.toList());

        return sortedList;
    }

    public List<User> sortByAllFields(List<User> list) {
        List<User> sortedList = list.stream().sorted(Comparator.comparing(User::getName).
                thenComparing(User::getAge)).collect(Collectors.toList());
        return sortedList;
    }
}

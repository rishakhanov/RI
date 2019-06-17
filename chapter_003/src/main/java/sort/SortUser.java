package sort;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> list) {
        Set<User> users = new TreeSet<>();
        users.addAll(list);
        return users;
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.name.length() - o2.name.length();
                    }
                }
        );
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result = o1.name.compareTo(o2.name);
                        return result != 0 ? result : o1.age.compareTo(o2.age);
                    }
                }
        );
        return list;
    }
}

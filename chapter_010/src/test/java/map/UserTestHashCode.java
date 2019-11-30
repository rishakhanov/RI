package map;

import org.junit.Test;

import java.util.*;

public class UserTestHashCode {

    public static final class User {
        String name;
        int children;
        Calendar birthday;

        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, children, birthday);
        }
    }

    @Test
    public void whenHashOnlyThen2Values() {
        User first = new User("Petr", 2, new GregorianCalendar(1990, 2, 2));
        User second = new User("Petr", 2, new GregorianCalendar(1990, 2, 2));
        Map<User, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }
}

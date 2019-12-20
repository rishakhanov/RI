/*
package map;

import org.junit.Test;

import java.util.*;

public class UserTestEquals {
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
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return children == user.children
                    && name.equals(user.name)
                    && birthday.equals(user.birthday);
        }
    }

    @Test
    public void whenEqualsThen2Values() {
        User first = new User("Petr", 2, new GregorianCalendar(1990, 2, 2));
        User second = new User("Petr", 2, new GregorianCalendar(1990, 2, 2));
        Map<User, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }
}
*/
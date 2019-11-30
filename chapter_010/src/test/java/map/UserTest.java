package map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
public class UserTest {

    public static final class User {
        String name;
        int children;
        Calendar birthday;

        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }
    }

    @Test
    public void whenNoHashEqualsThen2Values() {
        User first = new User("Petr", 2, new GregorianCalendar(1990, 2, 2));
        User second = new User("Petr", 2, new GregorianCalendar(1990, 2, 2));
        Map<User, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }
}

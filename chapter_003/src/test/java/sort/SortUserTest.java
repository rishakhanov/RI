package sort;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortUserTest {
    @Test
    public void whenFirstWordMoreSecondReturnSecondFirst() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        User u100 = new User("Name100", 100);
        User u20 = new User("Name20", 20);
        list.add(u100);
        list.add(u20);
        List<User> result = new ArrayList<>();
        result.add(u20);
        result.add(u100);
        assertThat(result, is(sortUser.sortNameLength(list)));
    }

    @Test
    public void whenListThenSortdedListByNameAndAge() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        User u1 = new User("Сергей", 25);
        User u2 = new User("Иван", 30);
        User u3 = new User("Сергей", 20);
        User u4 = new User("Иван", 25);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        List<User> result = new ArrayList<>();
        result.add(u4);
        result.add(u2);
        result.add(u3);
        result.add(u1);
        assertThat(result, is(sortUser.sortByAllFields(list)));
    }
}

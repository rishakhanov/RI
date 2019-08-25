package sort;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.List;

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
    public void whenListThenSortedListByNameAndAge() {
        SortUser sortUser = new SortUser();
        List<User> list = List.of(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        );
        List<User> actual = sortUser.sortByAllFields(list);
        List<User> expected = List.of(
                new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25)
        );
        assertThat(expected, is(actual));
    }
}

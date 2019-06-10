package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserConvertTest {
    @Test
    public void whenList3ThenMap3() {
        List<User> list = new ArrayList<>();
        User user1 = new User(101, "Name1", "City1");
        User user2 = new User(201, "Name2", "City2");
        User user3 = new User(301, "Name3", "City3");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(101, user1);
        expect.put(201, user2);
        expect.put(301, user3);
        UserConvert result = new UserConvert();
        assertThat(result.process(list), is(expect));
    }
}

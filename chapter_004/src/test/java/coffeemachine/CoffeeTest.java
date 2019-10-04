package coffeemachine;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoffeeTest {

    @Test
    public void whenInsert35MoneyReturnChanges() {
        Coffee coffee = new Coffee();
        List<Integer> expected = new ArrayList<>(Arrays.asList(10, 5));
        assertThat(coffee.changes(35, 20), is(expected));
    }

    @Test
    public void whenInsert40MoneyReturnChanges() {
        Coffee coffee = new Coffee();
        List<Integer> expected = new ArrayList<>(Arrays.asList(10, 10));
        assertThat(coffee.changes(40, 20), is(expected));
    }

    @Test
    public void whenInsert43MoneyReturnChanges() {
        Coffee coffee = new Coffee();
        List<Integer> expected = new ArrayList<>(Arrays.asList(10, 10, 2, 1));
        assertThat(coffee.changes(43, 20), is(expected));
    }

    @Test
    public void whenInsert20MoneyReturnChanges() {
        Coffee coffee = new Coffee();
        List<Integer> expected = new ArrayList<>(Arrays.asList());
        assertThat(coffee.changes(20, 20), is(expected));
    }
}

package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHasLength5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLength6ThenMinusOne() {
        FindLoop find2 = new FindLoop();
        int[] input2 = new int[] {7, 12, 20, 1};
        int value2 = 6;
        int result2 = find2.indexOf(input2, value2);
        int expect2 = -1;
        assertThat(result2, is(expect2));
    }
}

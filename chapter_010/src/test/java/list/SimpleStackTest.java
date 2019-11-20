package list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    private SimpleStack<Integer> simpleStack;

    @Before
    public void beforeTest() {
        simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
    }

    @Test
    public void whenDeleteThenLastItem() {
        assertThat(simpleStack.poll(), is(3));
    }

    @Test
    public void whenDelete3TimesThenFirstItem() {
        simpleStack.poll();
        simpleStack.poll();
        assertThat(simpleStack.poll(), is(1));
    }
}

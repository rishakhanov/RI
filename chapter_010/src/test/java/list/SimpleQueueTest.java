package list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    private SimpleQueue<Integer> simpleQueue;

    @Before
    public void beforeTest() {
        simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
    }

    @Test
    public void whenPollFirstThen1() {
        assertThat(simpleQueue.poll(), is(1));
    }

    @Test
    public void whenPollLastThen3() {
        simpleQueue.poll();
        simpleQueue.poll();
        assertThat(simpleQueue.poll(), is(3));
    }

    @Test
    public void whenPush1Push2PollPush3PollThen2() {
        simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.poll();
        simpleQueue.push(3);
        assertThat(simpleQueue.poll(), is(2));
    }
}

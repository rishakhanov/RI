package list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CycleTest {
    @Test
    public void whenCycleThenTrue() {
        Cycle cycle = new Cycle();
        assertThat(cycle.hasCycle(), is(true));
    }
}

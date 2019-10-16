package iterator;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IteratorArrayTest {

    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new IteratorArray(new int[][]{{1}, {3, 4}, {7}});
    }

    @Test
    public void whenGetNextCallShouldPointerForward() {
        it.next();
        it.next();
        int result = (Integer) it.next();
        assertThat(result, is(4));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        IteratorArray it = new IteratorArray(new int[][]{{1}, {3, 4}, {7}});
        assertThat(it.next(), Matchers.is(1));
        assertThat(it.next(), Matchers.is(3));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.next(), Matchers.is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        IteratorArray it = new IteratorArray(new int[][]{{1}, {3, 4}, {7}});
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(1));
        assertThat(it.next(), Matchers.is(3));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.next(), Matchers.is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        IteratorArray it = new IteratorArray(new int[][]{{1}, {3, 4}, {7}});
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(1));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(3));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(7));
        assertThat(it.hasNext(), Matchers.is(false));
    }
}

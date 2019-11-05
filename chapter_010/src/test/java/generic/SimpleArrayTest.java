package generic;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    private SimpleArray<String> simple;

    @Before
    public void setUp() {
        simple = new SimpleArray<>(4);
        simple.add("test");
        simple.add("test2");
        simple.add("test3");
        simple.add("test4");
    }

    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        String result = simple.get(1);
        assertThat(result, is("test2"));
    }

    @Test
    public void whenSetElementShouldReturnNewElement() {
        simple.set(1, "new");
        String result = simple.get(1);
        assertThat(result, is("new"));
    }

    @Test
    public void whenRemoveElementShouldMoveOtherElements() {
        simple.remove(1);
        String result = simple.get(2);
        assertThat(result, is("test4"));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        Iterator iterator = simple.iterator();
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.next(), Matchers.is("test"));
        assertThat(iterator.next(), Matchers.is("test2"));
        assertThat(iterator.next(), Matchers.is("test3"));
        assertThat(iterator.next(), Matchers.is("test4"));
    }
}

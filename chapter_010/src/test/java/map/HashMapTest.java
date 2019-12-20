package map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HashMapTest {

    private HashMapNew<String, Integer> hashMap;

    @Before
    public void before() {
        hashMap = new HashMapNew(16);
        hashMap.insert("one", 1);
        hashMap.insert("two", 2);
        hashMap.insert("three", 3);

    }

    @Test
    public void whenAddThreeItemsSecondItemIsTheSecondOne() {
        assertThat(hashMap.get("two"), is(2));
    }

    @Test
    public void whenDeleteThirdThenIsTrue() {
        assertThat(hashMap.delete("three"), is(true));
    }
}

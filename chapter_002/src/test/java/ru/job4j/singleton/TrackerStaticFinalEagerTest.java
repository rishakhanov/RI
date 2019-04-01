package ru.job4j.singleton;


import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerStaticFinalEagerTest {
    @Test
    public void whenCreateItemThenReturnSameItem() {
        TrackerStaticFinalEager trackerStaticFinalEager1 = TrackerStaticFinalEager.getInstance();
        TrackerStaticFinalEager trackerStaticFinalEager2 = TrackerStaticFinalEager.getInstance();
        assertThat(trackerStaticFinalEager1, is(trackerStaticFinalEager2));
    }
}

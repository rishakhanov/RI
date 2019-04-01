package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerStaticLazyTest {
    @Test
    public void whenCreateItemThenReturnSameItem() {
        TrackerStaticLazy trackerStaticLazy1 = TrackerStaticLazy.getInstance();
        TrackerStaticLazy trackerStaticLazy2 = TrackerStaticLazy.getInstance();
        assertThat(trackerStaticLazy1, is(trackerStaticLazy2));
    }
}

package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerStaticFinalLazyTest {
    @Test
    public void whenCreateItemThenReturnSameItem() {
        TrackerStaticFinalLazy trackerStaticFinalLazy1 = TrackerStaticFinalLazy.getInstance();
        TrackerStaticFinalLazy trackerStaticFinalLazy2 = TrackerStaticFinalLazy.getInstance();
        assertThat(trackerStaticFinalLazy1, is(trackerStaticFinalLazy2));
    }
}

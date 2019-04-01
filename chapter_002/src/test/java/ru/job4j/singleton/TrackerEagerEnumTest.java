package ru.job4j.singleton;

import org.junit.Test;
//import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerEagerEnumTest {
    @Test
    public void whenCreateItemThenReturnSameItem() {
        TrackerEagerEnum trackerEagerEnum1 = TrackerEagerEnum.INSTANCE;
        TrackerEagerEnum trackerEagerEnum2 = TrackerEagerEnum.INSTANCE;
        assertThat(trackerEagerEnum1, is(trackerEagerEnum2));
    }

    //public static void main(String[] args) {
    //    TrackerEagerEnum trackerEagerEnum = TrackerEagerEnum.INSTANCE;
    //}
}

package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L, "testComments");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker  = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L, "testComments");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L, "testComments2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenReturnNewTracker() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L, "testComments");
        Item item2 = new Item("test2", "testDescription2", 1234L, "testComments2");
        Item item3 = new Item("test3", "testDescription3", 12345L, "testComments3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item1.getId());
        Item[] item = {item2, item3};
        assertThat(tracker.findAll(), is(item));
    }

    @Test
    public void whenFoundNameThenReturnNewTracker() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L, "testComments");
        Item item2 = new Item("test2", "testDescription2", 1234L, "testComments2");
        Item item3 = new Item("test3", "testDescription3", 12345L, "testComments3");
        Item item4 = new Item("test2", "testDescription4", 123456L, "testComments4");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] item = new Item[4];
        item[0] = item2;
        item[1] = item4;
        assertThat(tracker.findByName("test2"), is(item));
    }


    @Test
    public void whenFoundIdThenReturnNewTracker() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L, "testComments");
        Item item2 = new Item("test2", "testDescription2", 1234L, "testComments2");
        Item item3 = new Item("test3", "testDescription3", 12345L, "testComments3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item3.getId()), is(item3));
    }
}

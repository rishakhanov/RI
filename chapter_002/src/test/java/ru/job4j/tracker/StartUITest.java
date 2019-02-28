package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
//import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserSelectGetAllThenTrackerReturnsAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Item item3 = tracker.add(new Item("name3", "desc3"));
        Input input = new StubInput(new String[]{"4", "5"});
        new StartUI(input, tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0 : Добавление заявки")
                                .append(System.lineSeparator())
                                .append("1 : Обновление заявки")
                                .append(System.lineSeparator())
                                .append("2 : Поиск заявки")
                                .append(System.lineSeparator())
                                .append("3 : Удаление заявки")
                                .append(System.lineSeparator())
                                .append("4 : Вывести все заявки")
                                .append(System.lineSeparator())
                                .append("5 : Выход")
                                .append(System.lineSeparator())
                                .append("----------------Вывод всех заявок------------")
                                .append(System.lineSeparator())
                                .append("name1" + " " + "desc1")
                                .append(System.lineSeparator())
                                .append("name2" + " " + "desc2")
                                .append(System.lineSeparator())
                                .append("name3" + " " + "desc3")
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0 : Добавление заявки")
                                .append(System.lineSeparator())
                                .append("1 : Обновление заявки")
                                .append(System.lineSeparator())
                                .append("2 : Поиск заявки")
                                .append(System.lineSeparator())
                                .append("3 : Удаление заявки")
                                .append(System.lineSeparator())
                                .append("4 : Вывести все заявки")
                                .append(System.lineSeparator())
                                .append("5 : Выход")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "5"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", item.getId(), "test replace", "заменили заявку", "5"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerDoesNotHaveDeletedValue() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Item item3 = tracker.add(new Item("name3", "desc3"));
        Input input = new StubInput(new String[]{"3", item2.getId(), "5"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[1].getName(), is("name3"));
    }

    @Test
    public void whenFindItemThenTrackerReturnFoundValue() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Item item3 = tracker.add(new Item("name3", "desc3"));
        Input input = new StubInput(new String[]{"2", item2.getId(), "5"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item2.getId()).getName(), is("name2"));
    }
}

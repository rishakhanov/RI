package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        List<Integer> menufill = new ArrayList<>();
        menufill = menu.fillRanges();
        do {
            menu.show();
            menu.select(input.ask("select:", menufill));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

     public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
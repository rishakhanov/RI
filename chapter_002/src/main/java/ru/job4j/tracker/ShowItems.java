package ru.job4j.tracker;

import java.util.List;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(4, "Вывести все заявки");
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("----------------Вывод всех заявок------------");
        List<Item> arrays = tracker.findAll();
        for (Item item : arrays) {
            System.out.println(item.getName() + " " + item.getDescription());
        }
    }
}

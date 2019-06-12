package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindItemName extends BaseAction {

    public FindItemName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("----------------Поиск заявки по имени------------");
        String name = input.ask("Введите имя заявки : ");
        List<Item> result = tracker.findByName(name);
        if (result.size() > 0) {
            for (Item item : result) {
                System.out.println("Заявка с id : " + item.getId() + " и с именем : " + item.getName());
            }
        }
    }
}

package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionsLength() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавление заявки"));
        this.actions.add(new UpdateItem(1, "Обновление заявки"));
        this.actions.add(new FindItem(2, "Поиск заявки"));
        this.actions.add(new DeleteItem(3, "Удаление заявки"));
        this.actions.add(new ShowItems(4, "Вывести все заявки"));
        this.actions.add(new FindItemName(5, "Поиск заявки по имени"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public int[] fillRanges() {
        int[] ranges = new int[getActionsLength()];
        for (int i = 0; i < getActionsLength(); i++) {
            ranges [i] = i;
        }
        return ranges;
    }

}
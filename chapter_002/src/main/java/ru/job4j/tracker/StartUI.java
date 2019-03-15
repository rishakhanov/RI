package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI {
    /*private static final String ADD = "0";
    private static final String UPDATE = "1";
    private static final String FIND = "2";
    private static final String DELETE = "3";
    private static final String GET = "4";
    private static final String EXIT = "5";*/
    private final Input input;
    private final Tracker tracker;
    private int[] ranges = new int[]{0, 1, 2, 3, 4};

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
       /* List<Integer> range = new ArrayList<>();*/
        menu.fillActions();
        /*for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }*/
        do {
            menu.show();
            menu.select(input.ask("select:", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

   /* private void createItem() {
        System.out.println("---------------Добавление новой заявки----------------");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки : ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("-----------Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void updateItem() {
        System.out.println("-----------------Обновление заявки------------");
        String id = this.input.ask("Введите id заявки : ");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки : ");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("Item was updated");
        } else {
            System.out.println("Item not found");
        }
    }

    private void findItem() {
        System.out.println("----------------Поиск заявки по id------------");
        String id = this.input.ask("Введите id заявки : ");
        Item result = this.tracker.findById(id);
        System.out.println("Заявка с id : " + result.getId() + " и с именем : " + result.getName());
    }

    private void deleteItem() {
        System.out.println("----------------Удаление заявки по id------------");
        String id = this.input.ask("Введите id заявки : ");
        if (this.tracker.delete(id)) {
            System.out.println("Item was deleted");
        } else {
            System.out.println("Item not found");
        }
    }

    private void getItem() {
        System.out.println("----------------Вывод всех заявок------------");
        Item[] arrays = this.tracker.findAll();
        for (Item item : arrays) {
            //System.out.println("Заявка с id : " + item.getId() + " и с именем " + item.getName());
            System.out.println(item.getName() + " " + item.getDescription());
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0 : Добавление заявки");
        System.out.println("1 : Обновление заявки");
        System.out.println("2 : Поиск заявки");
        System.out.println("3 : Удаление заявки");
        System.out.println("4 : Вывести все заявки");
        System.out.println("5 : Выход");
    }

*/
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}

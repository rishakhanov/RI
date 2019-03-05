package ru.job4j.tracker;

public class ShowItems implements UserAction {
    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("----------------Вывод всех заявок------------");
        Item[] arrays = tracker.findAll();
        for (Item item : arrays) {
            System.out.println(item.getName() + " " + item.getDescription());
        }
    }

    @Override
    public String info() {
        return "4 : Вывести все заявки";
    }
}

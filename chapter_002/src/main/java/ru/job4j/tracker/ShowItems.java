package ru.job4j.tracker;

public class ShowItems extends BaseAction {

    public ShowItems() {
        super(4, "Вывести все заявки");
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("----------------Вывод всех заявок------------");
        Item[] arrays = tracker.findAll();
        for (Item item : arrays) {
            System.out.println(item.getName() + " " + item.getDescription());
        }
    }
}

package ru.job4j.tracker;

public class FindItemName extends BaseAction {

    public FindItemName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("----------------Поиск заявки по имени------------");
        String name = input.ask("Введите имя заявки : ");
        Item[] result = tracker.findByName(name);
        if (result != null) {
            for (Item item : result) {
                System.out.println("Заявка с id : " + item.getId() + " и с именем : " + item.getName());
            }
        }
    }
}

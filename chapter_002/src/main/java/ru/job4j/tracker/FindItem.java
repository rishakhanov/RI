package ru.job4j.tracker;

public class FindItem extends BaseAction {

    public FindItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("----------------Поиск заявки по id------------");
        String id = input.ask("Введите id заявки : ");
        Item result = tracker.findById(id);
        if (result != null) {
            System.out.println("Заявка с id : " + result.getId() + " и с именем : " + result.getName());
        }
    }
}
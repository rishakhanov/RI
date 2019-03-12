package ru.job4j.tracker;

public class FindItem implements UserAction {
    @Override
    public int key() {
        return 2;
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

    @Override
    public String info() {
        return "2 : Поиск заявки";
    }
}

package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("----------------Удаление заявки по id------------");
        String id = input.ask("Введите id заявки : ");
        if (tracker.delete(id)) {
            System.out.println("Item was deleted");
        } else {
            System.out.println("Item not found");
        }
    }

    @Override
    public String info() {
        return "3 : Удаление заявки";
    }
}

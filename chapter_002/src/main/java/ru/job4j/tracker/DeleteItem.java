package ru.job4j.tracker;

public class DeleteItem extends BaseAction {

    public DeleteItem() {
        super(3, "Удаление заявки");
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
}

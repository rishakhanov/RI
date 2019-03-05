package ru.job4j.tracker;

public class UpdateItem implements UserAction {
    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("-----------------Обновление заявки------------");
        String id = input.ask("Введите id заявки : ");
        String name = input.ask("Введите имя заявки : ");
        String desc = input.ask("Введите описание заявки : ");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("Item was updated");
        } else {
            System.out.println("Item not found");
        }
    }

    @Override
    public String info() {
        return "1 : Обновление заявки";
    }
}

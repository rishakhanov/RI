package ru.job4j.tracker;

public class StartUI {
    private static final String ADD = "0";
    private static final String UPDATE = "1";
    private static final String FIND = "2";
    private static final String DELETE = "3";
    private static final String GET = "4";
    private static final String EXIT = "5";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (UPDATE.equals(answer)) {
                this.updateItem();
            } else if (FIND.equals(answer)) {
                this.findItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (GET.equals(answer)) {
                this.getItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void createItem() {
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
        this.tracker.replace(id, item);
    }

    private void findItem() {
        System.out.println("----------------Поиск заявки по id------------");
        String id = this.input.ask("Введите id заявки : ");
        this.tracker.findById(id);
    }

    private void deleteItem() {
        System.out.println("----------------Удаление заявки по id------------");
        String id = this.input.ask("Введите id заявки : ");
        this.tracker.delete(id);
    }

    private void getItem() {
        System.out.println("----------------Вывод всех заявок------------");
        this.tracker.findAll();
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

    public static void main(String[] args) {
        new StartUI(new Input(), new Tracker()).init();
    }
}

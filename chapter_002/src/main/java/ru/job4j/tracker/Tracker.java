package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */

import java.util.*;


public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище.
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public boolean replace(String id, Item itemnew) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = itemnew;
                this.items[i].setId(id);
                result = true;
                break;
            }
        }
        return result;

    }

    public boolean delete(String id) {
        boolean result = false;
        for (int point = 0; point < this.items.length; point++) {
            if (this.items[point] != null && this.items[point].getId().equals(id)) {
                System.arraycopy(this.items, point + 1, this.items, point, this.items.length - point - 1);
                result = true;
                this.position--;
                break;
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int point = 0;
        for (int pos = 0; pos < this.items.length; pos++) {
        //for (Item item : this.items) {
            if (this.items[pos] != null && this.items[pos].getName().equals(key)) {
                result[point] = this.items[pos];
                point++;
            }
        }
        return Arrays.copyOf(result, point);
    }

    /*public Item findByName(String name) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }*/

}

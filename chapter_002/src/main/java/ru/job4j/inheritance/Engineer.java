package ru.job4j.inheritance;

public class Engineer extends Profession {
    Engineer(String profession, String name) {
        super(profession, name);
    }

    public void build(House house) {
    }
}

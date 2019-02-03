package ru.job4j.inheritance;

public class Teacher extends Profession {
    Teacher(String profession, String name) {
        super(profession, name);
    }

    public void teach(Student student) {
    }
}

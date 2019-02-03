package ru.job4j.inheritance;

public class Doctor extends Profession {
    Doctor(String profession, String name) {
        super(profession, name);
    }

    public void cure(Patient name) {
    }

    public Diagnose heal(Patient patient) {
    }
}

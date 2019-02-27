package ru.job4j.pseudo;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder plc = new StringBuilder();
        plc.append("++++");
        plc.append("+  +");
        plc.append("+  +");
        plc.append("++++");
        return plc.toString();
    }
}

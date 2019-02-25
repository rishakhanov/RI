package ru.job4j.tracker;

import java.util.Scanner;

public class Input {
    public String ask(String input) {
        System.out.println(input);
        Scanner in = new Scanner(System.in);
        String answer = in.next();
        return answer;
    }
}

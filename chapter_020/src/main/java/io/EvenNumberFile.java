package io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                int x = Integer.parseInt(line);
                boolean rsl = x % 2 == 0;
                if (rsl) {
                    System.out.println("Число " + x + " четное");
                } else {
                    System.out.println("Число " + x + " нечетное");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

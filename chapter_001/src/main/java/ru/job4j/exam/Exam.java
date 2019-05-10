package ru.job4j.exam;

public class Exam {

    public static void main(String[] args) {
        int[] x = {1, 3, 2, 6, 0, 7};
        int[] y = {9, 8, 1, 12, 23};
        int[] z = new int[11];
        int control = 0;


        for (int i = 0; i < 11; i++) {
            if (control <= 5) {
                z[i] = x[i];
            } else {
                z[i] = y[i - x.length];
            }
            control++;
            System.out.println(z[i]);
        }
    }
}

package ru.job4j.exam;

public class Exam {

    public static void main(String[] args) {
        int[] x = {1, 3, 2, 6, 0, 7};
        int[] y = {9, 8, 1, 12, 23};
        printAll(merge(x, y));
    }

    public static int[] merge(int[] left, int[] right) {
        int control = 0;
        int[] z = new int[left.length + right.length];
        for (int i = 0; i < (left.length + right.length); i++) {
            if (control <= (left.length - 1)) {
                z[i] = left[i];
            } else {
                z[i] = right[i - left.length];
            }
            control++;
        }
        return z;
    }

    public static void printAll(int[] print) {
        for (int x : print) {
            System.out.println(x);
        }
    }
}

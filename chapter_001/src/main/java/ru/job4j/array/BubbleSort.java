package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    x = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;
    }
}

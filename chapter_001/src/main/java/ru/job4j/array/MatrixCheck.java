package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
            boolean result = true;
                for (int i = 1; i < data[0].length; i++) {
                   if ((data[i][i] != data[i - 1][i - 1]) || (data[i][data[0].length - 1 - i]
                      != data[i - 1][data[0].length - i])) {
                        result = false;
                        break;
                   }
                }
            return result;
    }
}

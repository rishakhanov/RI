package list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = rows;
        int[][] array = new int[rows][cells];
        int i = 0, j = 0;

        for (Integer element : list) {
            if (j < cells) {
                array[i][j] = element;
            }
            if (j < (cells - 1)) {
                j++;
            } else {
                i++;
                j = 0;
            }
        }
        return array;
    }
}

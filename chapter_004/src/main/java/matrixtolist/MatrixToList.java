package matrixtolist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[3][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i + j;
            }
        }
        System.out.println(Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList()));
    }
}

package matrixtolist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public List<Integer> matrixconvert(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}

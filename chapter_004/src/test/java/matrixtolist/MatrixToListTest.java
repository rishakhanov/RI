package matrixtolist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void whenMatrixThenList() {
        MatrixToList matrixToList = new MatrixToList();
        Integer[][] matrix = new Integer[2][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i + j;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        result.add(1);
        result.add(2);
        assertThat(result, is(matrixToList.matrixconvert(matrix)));
    }
}

package list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] element : list) {
            for (int value : element) {
                result.add(value);
            }
        }
        return result;
    }
}

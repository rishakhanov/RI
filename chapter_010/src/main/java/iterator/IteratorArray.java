package iterator;

import java.util.Arrays;
import java.util.Iterator;

public class IteratorArray implements Iterator {

    private final int[][] values;
    private int len, index, indexrow, indexcolumn  = 0;

    public IteratorArray(int[][] values) {
        this.values = values;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                len++;
            }
        }

    }

    @Override
    public boolean hasNext() {
        return len > index;
    }

    @Override
    public Object next() {
        index++;
        int result;
        result = values[indexrow][indexcolumn];
        if (indexcolumn == (values[indexrow].length - 1)) {
            indexcolumn = 0;
            indexrow++;
        } else {
            indexcolumn++;
        }
        return result;
    }
}

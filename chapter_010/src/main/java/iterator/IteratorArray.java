package iterator;

import java.util.Arrays;
import java.util.Iterator;

public class IteratorArray implements Iterator {

    private final int[][] values;
    private int index, indexrow, indexcolumn  = 0;

    public IteratorArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return indexrow < values.length;
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

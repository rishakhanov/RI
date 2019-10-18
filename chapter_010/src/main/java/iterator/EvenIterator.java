package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    private final int[] values;
    private int index, position = 0;

    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < values.length; i++) {
            if ((values.length > index) && (values[i] % 2 == 0)) {
                result = true;
                index = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() throws NoSuchElementException {
        int result = -1;
        if (hasNext()) {
            result = values[index];
            index++;
        }
        if (result == -1) {
            throw new NoSuchElementException();
        }
        return result;
    }
}

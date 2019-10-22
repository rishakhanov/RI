package generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;
    private int indexRowObjects, indexRowIterator = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T value) {
        this.objects[indexRowObjects++] = value;
    }

    public T get(int position) {
        return (T) this.objects[position];
    }

    public void set(int indexRow, T model) {
        this.objects[indexRow] = model;
    }

    public void remove(int indexRow) {
        objects[indexRow] = null;
        while (indexRow < objects.length - 1) {
            objects[indexRow] = objects[indexRow + 1];
            indexRow++;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (objects[indexRowIterator] != null) {
                    result = true;
                }
                return result;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return objects[indexRowIterator++];
            }
        };
    }
}

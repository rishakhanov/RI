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
        T result = null;
        if (position < this.objects.length) {
            result = (T) this.objects[position];
        }
        return result;
    }

    public void set(int indexRow, T model) {
        if (indexRow < this.objects.length) {
            this.objects[indexRow] = model;
        }
    }

    public void remove(int indexRow) {
        System.arraycopy(this.objects, indexRow + 1, this.objects, indexRow, this.objects.length - indexRow - 1);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (indexRowIterator < objects.length) {
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

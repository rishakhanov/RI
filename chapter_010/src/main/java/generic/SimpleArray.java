package generic;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;
    private int indexRowObjects = 0;
    private int modcount = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T value) {
        if (indexRowObjects == objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[indexRowObjects++] = value;
        modcount++;
    }

    public T get(int position) {
        T result = null;
        if (position < indexRowObjects) {
            result = (T) this.objects[position];
        }
        return result;
    }

    public void set(int indexRow, T model) {
        if (indexRow < indexRowObjects) {
            this.objects[indexRow] = model;
        }
    }

    public void remove(int indexRow) {
        System.arraycopy(this.objects, indexRow + 1, this.objects, indexRow, this.objects.length - indexRow - 1);
        indexRowObjects--;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int indexRowIterator;
            private int expectedModCount = modcount;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (expectedModCount != modcount) {
                    throw new ConcurrentModificationException();
                }
                if (indexRowIterator < indexRowObjects) {
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

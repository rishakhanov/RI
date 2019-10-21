package generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    Object[] objects;
    int index, index2 = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T value) {
        this.objects[index++] = value;
    }

    public T get(int position) {
        return (T) this.objects[position];
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public void remove(int index) {
        int i = index;
        objects[i] = null;
        while (i < objects.length - 1) {
            objects[i] = objects[i + 1];
            i++;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (objects[index2] != null) {
                    result = true;
                }
                return result;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return objects[index2++];
            }
        };
    }
}

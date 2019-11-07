package list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ContainerArray<E> implements Iterable<E> {

    private Object[] container;
    private int modcount = 0;
    private int indexRowObjects = 0;
    int size;

    public ContainerArray(int size) {
        this.container = new Object[size];
        this.size = size;
    }

    public void add(E value) {
        if (indexRowObjects >= container.length) {
            container = Arrays.copyOf(container, size + size);
            modcount++;
        }
        this.container[indexRowObjects++] = value;
    }

    public E get(int index) {
        E result = null;
        if (index < indexRowObjects) {
            result = (E) this.container[index];
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int indexRowIterator;
            int expectedModCount = modcount;
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
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[indexRowIterator++];
            }
        };
    }
}

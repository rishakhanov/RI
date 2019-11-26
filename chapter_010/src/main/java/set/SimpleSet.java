package set;

import list.ContainerArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E> implements Iterable<E> {

    private ContainerArray<E> containerArray = new ContainerArray<>(10);
    private int modcount = 0;
    private int indexRowObjects = 0;

    public void add(E value) {
        boolean check = true;
        for (E item: containerArray) {
            if (item.equals(value)) {
                check = false;
                break;
            }
        }
        if (check) {
            containerArray.add(value);
            modcount++;
            indexRowObjects++;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
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
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) containerArray.get(indexRowIterator++);
            }
        };
    }
}

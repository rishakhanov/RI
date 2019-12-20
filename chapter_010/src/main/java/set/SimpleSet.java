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
        if (contains(value)) {
            containerArray.add(value);
            modcount++;
            indexRowObjects++;
        }
    }

    public boolean contains(E value) {
        boolean check = true;
        for (E item: containerArray) {
            if (item.equals(value)) {
                check = false;
                break;
            }
        }
        return  check;
    }

    @Override
    public Iterator<E> iterator() {
        return containerArray.iterator();
    }
}

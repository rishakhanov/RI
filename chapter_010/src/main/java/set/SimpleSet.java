package set;

import list.ContainerArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    private ContainerArray<E> containerArray = new ContainerArray<>(10);

    public void add(E value) {
        if (contains(value)) {
            containerArray.add(value);
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

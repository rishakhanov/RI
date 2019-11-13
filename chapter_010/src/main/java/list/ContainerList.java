package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ContainerList<E> implements Iterable<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.head;
        if (size >= 1) {
            this.head.prev = newLink;
        }
        this.head = newLink;
        this.size++;
        if (size == 1) {
            tail = this.head;
        }
    }

    public E get(int index) {
        Node<E> result = this.head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return size;
    }

    public E deleteHead() {
        Node<E> deletedItem;
        if (this.size < 1) {
            throw new NoSuchElementException();
        }
        deletedItem = this.head;
        deletedItem.data = this.head.data;
        this.head = null;
        this.size--;
        return deletedItem.data;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int indexRowIterator;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (indexRowIterator < size) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(indexRowIterator++);
            }
        };
    }
}

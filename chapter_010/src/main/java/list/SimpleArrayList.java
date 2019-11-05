package list;


import javafx.scene.Node;

public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public E delete() {
        Node<E> deletedItem;
        Node<E> result = this.first;
        for (int i = 0; i < this.getSize() - 1; i++) {
            result  = result.next;
        }
        deletedItem = result;
        deletedItem.data = result.data;
        result = null;
        this.size--;
        return deletedItem.data;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result  = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return size;
    }

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}

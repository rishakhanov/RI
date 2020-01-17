package tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount = 0;

    public Tree(E value) {
        this.root = new Node<E>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isEmpty()) {
            return false;
        }

        Optional<Node<E>> currentChild = findBy(child);
        if (currentChild.isPresent()) {
            if (currentChild.get().eqValue(child)) {
                return false;
            }
        }

        parentNode.get().add(new Node<E>(child));
        modCount++;
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private final int expectedModCount = modCount;
            Queue<Node<E>> elements = new LinkedList<>(Arrays.asList(root));

            private void addToQueue(Node<E> item) {
                for (Node<E> child : item.leaves()) {
                    elements.offer(child);
                }
            }

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return elements.peek() != null;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                addToQueue(elements.peek());
                return elements.poll().getValue();
            }
        };
    }
}

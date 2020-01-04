package map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashMapNew<K, V> implements Iterable<V> {
    private int size;
    private Node[] table;
    private int countItems = 0;
    private double loadfactor = 0.75;
    private int modCount = 0;

    public HashMapNew(int size) {
        this.size = size;
        table = new Node[size];
    }

    private class Node<K, V> {
        K key;
        V value;
        int hash;
        Node next;

        Node(K k, V v) {
            key = k;
            value = v;
            hash = hash(k);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public int getHash() {
            return hash;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private int hash(Object k) {
        int h = k.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexFor(int h, int length) {
        return h & (length - 1);
    }

    public V get(K k) {
        int index = indexFor(hash(k), size);
        Node node = table[index];
        if (node.key == k || node.key.equals(k)) {
            return (V) node.getValue();
        }
        return null;
    }

    public boolean insert(K k, V v) {
        if ((countItems / size) >= loadfactor) {
            resize();
        }

        boolean check = false;
        int index = indexFor(hash(k), size);
        Node node = table[index];
        if (node != null) {
            if (node.key == k || node.key.equals(k)) {
                node.value = v;
            }
        } else {
            Node newNode = new Node(k, v);
            table[index] = newNode;
            countItems++;
            modCount++;
            check = true;
        }
        return check;
    }

    public void resize() {
        size = size * 2;
        Node[] tableNew = new Node[size];
        for (Node node: table) {
            tableNew[indexFor(hash(node.getKey()), size)] = node;
        }
        table = tableNew;
    }

    public boolean delete(K k) {
        boolean result = false;
        int index = indexFor(hash(k), size);
        if (index <= size) {
            table[index] = null;
            countItems--;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int indexRowIterator = 0;
            private int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = indexRowIterator; i < size; i++) {
                    if (table[i] != null) {
                        indexRowIterator = i;
                        break;
                    }
                }
                if (indexRowIterator < countItems) {
                    result = true;
                }
                return result;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (V) table[indexRowIterator++].getValue();
            }
        };
    }
}

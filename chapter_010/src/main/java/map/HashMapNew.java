package map;

public class HashMapNew<K, V> {
    private int size;
    private Node[] table;

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
        while (node != null) {
            if ((node.hash == hash(k)) && (node.key == k || node.key.equals(k))) {
                return (V) node.value;
            }
        }
        return null;
    }

    public boolean insert(K k, V v) {
        int index = indexFor(hash(k), size);
        Node node = table[index];
        if (node != null) {
            return false;
        } else {
            Node newNode = new Node(k, v);
            table[index] = newNode;
            return true;
        }
    }

    public boolean delete(K k) {
        boolean result = false;
        int index = indexFor(hash(k), size);
        if (index <= size) {
            table[index] = null;
            result = true;
        }
        return result;
    }
}

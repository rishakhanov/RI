package list;

public class Cycle {

    class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    Node<Integer> first = new Node<Integer>(1);
    Node<Integer> two = new Node<Integer>(2);
    Node<Integer> third = new Node<Integer>(3);
    Node<Integer> four = new Node<Integer>(4);
    //Node<Integer> five = new Node<Integer>(5);

    public boolean hasCycle() {
        boolean result = false;
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        Node[] objects = new Node[4];
        objects[0] = first;
        objects[1] = two;
        objects[2] = third;
        objects[3] = four;

        for (int i = 1; i < objects.length; i++) {
            if ((objects[i].next.equals(objects[i - 1])) || (objects[i].next.equals(objects[0]))) {
                result = true;
            }
        }
        return result;
    }
}

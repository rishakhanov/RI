package list;

public class Cycle {

    Node<Integer> first;
    Node<Integer> two;
    Node<Integer> third;
    Node<Integer> four;

    Cycle() {
        first = new Node<Integer>(1);
        two = new Node<Integer>(2);
        third = new Node<Integer>(3);
        four = new Node<Integer>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
    }

    class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public boolean hasCycle() {
        Node tortoise = first;
        Node hare = first;

        while (true) {
            tortoise = tortoise.next;

            if (hare.next != null) {
                hare = hare.next.next;
            } else {
                return false;
            }

            if ((tortoise == null) || (hare == null)) {
                return false;
            }

            if (tortoise == hare) {
                return true;
            }
        }
    }
}

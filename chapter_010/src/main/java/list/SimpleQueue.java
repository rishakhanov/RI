package list;

public class SimpleQueue<T> {
    private SimpleStack<T> initQueue = new SimpleStack<>();
    private SimpleStack<T> finQueue = new SimpleStack<>();
    private int size = 0;

    public void push(T value) {
        size++;
        if (size == 1) {
            finQueue.push(value);
        } else {
            int index = size;
            while (index > 1) {
                initQueue.push(finQueue.poll());
                index--;
            }
            initQueue.push(value);
            for (int i = 0; i < size; i++) {
                finQueue.push(initQueue.poll());
            }
        }
    }

    public T poll() {
        size--;
        return finQueue.poll();
    }
}

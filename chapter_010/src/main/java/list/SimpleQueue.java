package list;

public class SimpleQueue<T> {
    private SimpleStack<T> initQueue = new SimpleStack<>();
    private SimpleStack<T> finQueue = new SimpleStack<>();
    private int count = 0;

    public void push(T value) {
        initQueue.push(value);
        count++;
    }

    public T poll() {
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                finQueue.push(initQueue.poll());
            }
        }
        count = 0;
        return finQueue.poll();
    }
}

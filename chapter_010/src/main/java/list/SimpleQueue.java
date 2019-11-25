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
        /*
        T item = null;
        for (int i = 0; i < count; i++) {
            finQueue.push(initQueue.poll());
        }
        item = finQueue.poll();
        count--;
        for (int i = 0; i < count; i++) {
            initQueue.push(finQueue.poll());
        }
        return item;
        */
        T item = null;
        int i = 0;
        while (i <= (count * 2) - 1) {
            if (i < count) {
                finQueue.push(initQueue.poll());
            }
            if (i == count) {
                item = finQueue.poll();
            }
            if (i > count) {
                initQueue.push(finQueue.poll());
            }
            i++;
        }
        count--;
        return item;
    }
}

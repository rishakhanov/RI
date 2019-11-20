package list;

public class SimpleStack<T> {
    private ContainerList<T> list = new ContainerList<T>();
    public void push(T value) {
        list.add(value);
    }

    public T poll() {
        return list.deleteHead();
    }

}

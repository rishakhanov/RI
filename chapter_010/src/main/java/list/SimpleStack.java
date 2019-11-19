package list;

public class SimpleStack<T> {
    private ContainerList<T> containerList = new ContainerList<T>();
    public void push(T value) {
        containerList.add(value);
    }

    public T poll() {
        containerList.deleteHead();
    }

}

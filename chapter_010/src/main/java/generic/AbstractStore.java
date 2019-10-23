package generic;

public abstract class AbstractStore<T> {
    public int getIndex(T model, SimpleArray<T> objects) {
        int result = 0;
        while (objects.iterator().hasNext()) {
            if (objects.iterator().next().equals(model)) {
                break;
            } else {
                result++;
            }
        }
        return result;
    }
}

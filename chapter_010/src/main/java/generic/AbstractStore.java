package generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    SimpleArray<T> objects = new SimpleArray<>(10);

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

    @Override
    public void add(T model) {
        objects.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        T target = objects.get(getIndex(findById(id), objects));
        objects.set(getIndex(findById(id), objects), model);
        boolean result = true;
        for (T item: objects) {
            if (item.equals(target)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        T target = objects.get(getIndex(findById(id), objects));
        objects.remove(getIndex(findById(id), objects));
        boolean result = true;
        for (T item: objects) {
            if (item.equals(target)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T item: objects) {
            if (item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }
}

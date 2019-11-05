package generic;

import java.util.Iterator;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    SimpleArray<T> objects = new SimpleArray<>(10);

    public int getIndex(String id) {
        int result = -1;
        boolean exist = false;
        Iterator<T> iterator = objects.iterator();
        while (iterator.hasNext()) {
            result++;
            if (iterator.next().getId().equals(id)) {
                exist = true;
                break;
            }
        }
        return exist ? result : -1;
    }

    @Override
    public void add(T model) {
        objects.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean res = false;
        int index = getIndex(id);
        if (index != -1) {
            objects.set(index, model);
            res = true;
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res = false;
        int index = getIndex(id);
        if (index != -1) {
            objects.remove(index);
            res = true;
        }
        return res;
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

package generic;

public class RoleStore extends AbstractStore implements Store<Role> {

    SimpleArray<Role> objects = new SimpleArray<>(10);

    @Override
    public void add(Role model) {
        objects.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        Role target = objects.get(getIndex(findById(id), objects));
        objects.set(getIndex(findById(id), objects), model);
        //Role target = objects.get(getIndexByRole(findById(id)));
        //objects.set(getIndexByRole(findById(id)), model);
        boolean result = true;
        for (Role item: objects) {
            if (item.equals(target)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        Role target = objects.get(getIndex(findById(id), objects));
        objects.remove(getIndex(findById(id), objects));
        //Role target = objects.get(getIndexByRole(findById(id)));
        //objects.remove(getIndexByRole(findById(id)));
        boolean result = true;
        for (Role item: objects) {
            if (item.equals(target)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public Role findById(String id) {
        Role result = null;
        for (Role item: objects) {
            if (item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }

    /*
    public int getIndexByRole(Role role) {
        int result = 0;
        for (Role item: objects) {
            if (item.equals(role)) {
                break;
            } else {
                result++;
            }
        }
        return result;
    }
    */
}

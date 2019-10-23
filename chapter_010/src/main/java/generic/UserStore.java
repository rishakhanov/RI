package generic;

public class UserStore extends AbstractStore implements Store<User> {

    SimpleArray<User> objects = new SimpleArray<>(10);

    @Override
    public void add(User model) {
        objects.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        User target = objects.get(getIndex(findById(id), objects));
        objects.set(getIndex(findById(id), objects), model);
        //User target = objects.get(getIndexByUser(findById(id)));
        //objects.set(getIndexByUser(findById(id)), model);
        boolean result = true;
        for (User item: objects) {
            if (item.equals(target)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        User target = objects.get(getIndex(findById(id), objects));
        objects.remove(getIndex(findById(id), objects));
        //User target = objects.get(getIndexByUser(findById(id)));
        //objects.remove(getIndexByUser(findById(id)));
        boolean result = true;
        for (User item: objects) {
            if (item.equals(target)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public User findById(String id) {
        User result = null;
        for (User item: objects) {
            if (item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }

    /*
    public int getIndexByUser(User user) {
        int result = 0;
        for (User item: objects) {
            if (item.equals(user)) {
                break;
            } else {
                result++;
            }
        }
        return result;
    }
    */
}

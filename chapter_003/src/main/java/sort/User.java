package sort;

public class User implements Comparable<User> {
    public String name;
    public Integer age;
    String template = "str = '%s', num = %d";

    User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return age - o.age;
    }

    @Override
    public String toString() {
        return String.format(template, name, age);
    }
}

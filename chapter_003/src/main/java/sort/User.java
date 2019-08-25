package sort;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name)
                && age.equals(user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getNameLength() {
        return name.length();
    }
}

package sort;

public class User implements Comparable<User> {
    public String name;
    public Integer age;
    String template = "str = '%s', num = %d";

    User (String name, Integer age) {
        this.name = name;
        this.age =age;
    }

    @Override
    public int compareTo(User o) {
        int result = age - o.age;

        return result !=0 ? (int) result / Math.abs(result) : 0;
    }

    @Override
    public String toString() {
        return String.format(template, name, age);
    }
}

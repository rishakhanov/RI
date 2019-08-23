package students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return scope == student.scope && name.equals(student.name);
    }

    @Override
    public int hashCode() {

        return scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        int result;
        if (o1 == null) {
            result = -1;
        } else if (o2 == null) {
            result = 1;
        } else {
            result = o1.getScope() - o2.getScope();
        }
        return result;
    }
}

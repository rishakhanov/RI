package listtomap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {

    Student student1 = new Student(10, "Name1");
    Student student2 = new Student(20, "Name2");
    Student student3 = new Student(30, "Name3");
    Student student4 = new Student(40, "Name4");
    Student student5 = new Student(50, "Name5");
    Student student6 = new Student(60, "Name6");
    Student student7 = new Student(70, "Name7");
    Student student8 = new Student(80, "Name8");
    Student student9 = new Student(90, "Name9");
    Student student10 = new Student(100, "Name10");
    List<Student> input = new ArrayList<>();

    HashMap<String, Object> newmap = new HashMap<String, Object>();

    public HashMap<String, Object> returnmap (List<Student> studentList) {
    for (Student student : studentList) {
            newmap.put(student.getName(), student);
        }
    return newmap;
    }
}

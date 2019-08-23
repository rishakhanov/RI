package students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentSort {

    public List<Student> levelOf(List<Student> students, int bound) {
        List <Student> result = students.stream().flatMap(Stream::ofNullable).collect(Collectors.toList());
        return result;
    }
}

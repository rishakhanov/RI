package students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentSort {

    public List<Student> levelOf(List<Student> students, int bound) {
        List<Student> result = students.stream().sorted(Comparator.comparing(Student::getScope)).
                flatMap(Stream::ofNullable).takeWhile(v -> v.getScope() > bound).collect(Collectors.toList());
        return result;
    }
}

package listtomap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Convert {

    public Map<String, Student> returnmap(List<Student> studentList) {
        return studentList.stream().collect(
                Collectors.toMap(
                        e -> e.getName(),
                        e -> e
                )
        );
    }
}

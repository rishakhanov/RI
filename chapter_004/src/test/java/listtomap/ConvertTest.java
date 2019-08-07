package listtomap;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertTest {
    @Test
    public void whenListThenMap() {
        Student student1 = new Student(10, "Name1");
        Student student2 = new Student(20, "Name2");
        Student student3 = new Student(30, "Name3");
        List<Student> studentList = Arrays.asList(student1, student2, student3);

        Map<String, Student> result = new Convert().returnmap(studentList);
        assertThat(result.get("Name1"), is(student1));
        assertThat(result.get("Name2"), is(student2));
        assertThat(result.get("Name3"), is(student3));
    }
}

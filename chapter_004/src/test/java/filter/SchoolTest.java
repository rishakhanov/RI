package filter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    /*
     * Тест для диапазона [0, 50)
     */
    @Test
    public void whenList1ThenReturnFilteredList() {
        Student student1 = new Student(10);
        Student student2 = new Student(20);
        Student student3 = new Student(30);
        Student student4 = new Student(40);
        Student student5 = new Student(50);
        Student student6 = new Student(60);
        Student student7 = new Student(70);
        Student student8 = new Student(80);
        Student student9 = new Student(90);
        Student student10 = new Student(100);
        List<Student> list1 = new ArrayList<>();
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
        list1.add(student4);
        List<Student> input = new ArrayList<>();
        input.add(student1);
        input.add(student2);
        input.add(student3);
        input.add(student4);
        input.add(student5);
        input.add(student6);
        input.add(student7);
        input.add(student8);
        input.add(student9);
        input.add(student10);
        School school = new School();
        List<Student> result = school.collect(
                input,
                task -> (task.getScore() >= 0 && task.getScore() < 50)
        );
        assertThat(result, is(list1));
    }

    /*
     * Тест для диапазона (50, 70]
     */
    @Test
    public void whenList2ThenReturnFilteredList() {
        Student student1 = new Student(10);
        Student student2 = new Student(20);
        Student student3 = new Student(30);
        Student student4 = new Student(40);
        Student student5 = new Student(50);
        Student student6 = new Student(60);
        Student student7 = new Student(70);
        Student student8 = new Student(80);
        Student student9 = new Student(90);
        Student student10 = new Student(100);
        List<Student> list2 = new ArrayList<>();
        list2.add(student6);
        list2.add(student7);
        List<Student> input = new ArrayList<>();
        input.add(student1);
        input.add(student2);
        input.add(student3);
        input.add(student4);
        input.add(student5);
        input.add(student6);
        input.add(student7);
        input.add(student8);
        input.add(student9);
        input.add(student10);
        School school = new School();
        List<Student> result = school.collect(
                input,
                task -> (task.getScore() > 50 && task.getScore() <= 70)
        );
        assertThat(result, is(list2));
    }

    /*
     * Тест для диапазона (70, 100]
     */
    @Test
    public void whenList3ThenReturnFilteredList() {
        Student student1 = new Student(10);
        Student student2 = new Student(20);
        Student student3 = new Student(30);
        Student student4 = new Student(40);
        Student student5 = new Student(50);
        Student student6 = new Student(60);
        Student student7 = new Student(70);
        Student student8 = new Student(80);
        Student student9 = new Student(90);
        Student student10 = new Student(100);
        List<Student> list3 = new ArrayList<>();
        list3.add(student8);
        list3.add(student9);
        list3.add(student10);
        List<Student> input = new ArrayList<>();
        input.add(student1);
        input.add(student2);
        input.add(student3);
        input.add(student4);
        input.add(student5);
        input.add(student6);
        input.add(student7);
        input.add(student8);
        input.add(student9);
        input.add(student10);
        School school = new School();
        List<Student> result = school.collect(
                input,
                task -> (task.getScore() > 70 && task.getScore() <= 100)
        );
        assertThat(result, is(list3));
    }
}

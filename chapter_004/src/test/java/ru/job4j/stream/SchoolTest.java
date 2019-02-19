package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class SchoolTest
 * project lesson 4.2.1
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 18.02.2019
 */
public class SchoolTest {
    private final School school = new School();
    private final List<Student> students = Arrays.asList(
            new Student("Ivan", 45),
            new Student("Pavel", 75),
            new Student("Inna", 98),
            new Student("Olga", 30),
            new Student("Ula", 69),
            new Student("Jon", 55)
    );
    private final List<Student> group10A = Arrays.asList(
            new Student("Pavel", 75),
            new Student("Inna", 98)
    );
    private final List<Student> group10B = Arrays.asList(
            new Student("Ula", 69),
            new Student("Jon", 55)
    );
    private final List<Student> group10C = Arrays.asList(
            new Student("Ivan", 45),
            new Student("Olga", 30)
    );

    @Test
    public void whenGroup10A() {
        List<Student> resultList =
                school.collect(students, student ->
                        student.getScore() > 70 && student.getScore() <= 100);
        String expect = toName(this.group10A);
        String result = toName(resultList);
        assertThat(result, is(expect));
    }

    @Test
    public void whenGroup10B() {
        School school = new School();
        List<Student> resultList =
                school.collect(students, student ->
                        student.getScore() > 50 && student.getScore() <= 70);
        String expect = toName(this.group10B);
        String result = toName(resultList);
        assertThat(result, is(expect));
    }

    @Test
    public void whenGroup10C() {
        School school = new School();
        List<Student> resultList =
                school.collect(students, student ->
                        student.getScore() >= 0 && student.getScore() <= 50);
        String expect = toName(this.group10C);
        String result = toName(resultList);
        assertThat(result, is(expect));
    }


    /**
     * using method List to string only name
     *
     * @param students List of Studends (name and score)
     * @return string only name
     */
    private String toName(List<Student> students) {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.getName()).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }


}
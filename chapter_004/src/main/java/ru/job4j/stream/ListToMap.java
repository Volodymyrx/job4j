package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * class ListToMap
 * project lesson 4.2.4
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 18.05.2019
 */
public class ListToMap {
    /**
     * method to convert List of Student to Map key=Student.name, value=object student
     * @param students List of Students
     * @return Map key=Student.name, value=object student
     */
    public Map toMapStudends(List<Student> students) {
        return students.stream().distinct().collect(
                Collectors.toMap(
                        Student::getName,
                        student -> student
                ));
    }

}

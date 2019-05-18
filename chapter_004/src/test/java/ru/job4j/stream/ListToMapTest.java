package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class ListToMapTest
 * project lesson 4.2.4
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 18.05.2019
 */
public class ListToMapTest {

    private final ListToMap listToMap = new ListToMap();
    private final List<Student> students = Arrays.asList(
            new Student("Ivan", 45),
            new Student("Pavel", 75),
            new Student("Inna", 98),
            new Student("Olga", 30),
            new Student("Ula", 69),
            new Student("Jon", 55)
    );

    private final Map<String, Student> studentsMap = Map.of(
            "Ivan", new Student("Ivan", 45),
            "Pavel", new Student("Pavel", 75),
            "Inna", new Student("Inna", 98),
            "Olga", new Student("Olga", 30),
            "Ula", new Student("Ula", 69),
            "Jon", new Student("Jon", 55)
    );

    @Test
    public void studentToMap() {
        String  result = utilMapToString(listToMap.toMapStudends(students));
        String  expect = utilMapToString(studentsMap);
        assertThat(result, is(expect));
    }

    /**
     * using method Map to Tree Map and to string
     *
     * @param mapStudents Map key=name value=object Student (name and score)
     * @return string sorted Map
     */
    private String utilMapToString(Map<String, Student> mapStudents) {
        Map<String ,Student> sortMap=new TreeMap<>(mapStudents);
        return sortMap.keySet().stream()
                .map(key -> "key " + key + " -Object Student: " + sortMap.get(key).getName()+" "+sortMap.get(key).getScore())
                .collect(Collectors.joining(",", "{", "}"));
    }

}
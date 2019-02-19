package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;

/**
 * class School
 * project lesson 4.2.1
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 18.02.2019
 */
public class School {

    /**
     * method to choose from list according to condition
     *
     * @param students  List of Student
     * @param predicate - condition of choosing
     * @return List of Student
     */
    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(
                predicate
        ).collect(Collectors.toList());
    }
}

package ru.job4j.set;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * class SortUser
 * project lesson 3.3.1
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 25.11.2018
 */
public class SortUser {
    /**
     * contert list to TreeSet
     * in version by IDEA
     *
     * @param list with User implements Comparable
     * @return sort ThreeSet Users
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}

package ru.job4j.set;

import java.util.*;

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

    /**
     * sorted list by lenght of name
     *
     * @param list any list
     * @return sorted list by length of name
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(o1.getName().length(), o2.getName().length());
                    }
                }
        );
        return list;
    }

    /**
     * sorted list by Name and then Age
     *
     * @param list any list
     * @return sorted list
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result = o1.getName().compareTo(o2.getName());
                        return (result != 0) ? result : Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );
        return list;
    }

}

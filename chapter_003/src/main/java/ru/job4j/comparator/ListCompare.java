package ru.job4j.comparator;

import java.util.Comparator;

/**
 * class ListCompare
 * project lesson 3.3.3
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 26.11.2018
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int leghtMin = (left.length() < right.length()) ? left.length() : right.length();
        for (int i = 0; i < leghtMin; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
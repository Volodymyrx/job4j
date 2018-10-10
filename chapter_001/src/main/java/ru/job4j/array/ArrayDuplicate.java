package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate
 * remove duplicate from string array
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.8
 * @version 1.0
 * @since 10.10.2018
 */
public class ArrayDuplicate {
    /**
     * method remove duplicate from string array
     *
     * @param array is string array with duplicate
     * @return array without duplicate
     */
    public String[] remove(String[] array) {
        int uniqe = array.length;
        for (int out = 0; out < uniqe - 1; out++) {
            for (int in = out + 1; in < uniqe; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[uniqe - 1];

                    uniqe--;
                    in--;
                }
            }
        }
        array = Arrays.copyOf(array, uniqe);
        return array;
    }
}




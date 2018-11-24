package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * class ConvertList
 * project lesson 3.3.1
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 24.11.2018
 */
public class ConvertList {

    /**
     * method converted List of int[] to List Integer
     *
     * @param list List arrays int[]
     * @return Lits Integer
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] ints : list) {
            for (int anInt : ints) {
                result.add(anInt);
            }
        }
        return result;
    }
}

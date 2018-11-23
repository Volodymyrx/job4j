package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * class ConvertMatrix2List
 * project lesson 3.4
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 22.11.2018
 */
public class ConvertMatrix2List {

    /**
     * convert int array to list
     *
     * @param array int array
     * @return list
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList();
        for (int[] rows : array) {
            for (int cell : rows) {
                list.add(cell);
            }
        }
        return list;
    }
}
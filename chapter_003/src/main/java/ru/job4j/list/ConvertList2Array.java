package ru.job4j.list;

import java.util.List;

/**
 * class ConvertList2Array
 * project lesson 3.3
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 21.11.2018
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells += 1;
        }
        int indexList = 0;
        int[][] array = new int[rows][cells];
        for (int row = 0; row < rows; row++) {
            for (int cell = 0; cell < cells; cell++) {
                if (indexList < list.size()) {
                    array[row][cell] = list.get(indexList++);
                } else {
                    array[row][cell] = 0;
                }
            }
        }
        return array;
    }
}
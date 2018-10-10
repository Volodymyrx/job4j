package ru.job4j.array;

/**
 * Matrix
 * print taple multiple
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.6
 * @version 1.0
 * @since 10.10.2018
 */
public class Matrix {
    /**
     * method sort - sorting array int
     *
     * @param size - is size of table size on size
     * @return int array table
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}





package ru.job4j.array;

/**
 * Square
 * calculate array
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.0
 * @version 1.0
 * @since 10.10.2018
 */

public class Square {
    /**
     * method calculate array with square evry items
     *
     * @param bound height array
     * @return array squared int
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}




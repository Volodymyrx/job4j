package ru.job4j.array;

/**
 * FindLoop
 * finding number in array
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.1
 * @version 1.0
 * @since 10.10.2018
 */

public class FindLoop {
    /**
     * method indexOf number in array
     *
     * @param el for serching and array
     * @return index of number in array
     * if not finding return -1.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}





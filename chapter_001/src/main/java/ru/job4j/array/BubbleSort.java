package ru.job4j.array;

/**
 * BubbleSort
 * sort array
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.5
 * @version 1.0
 * @since 10.10.2018
 */
public class BubbleSort {
    /**
     * method sort - sorting array int
     *
     * @param array unsorted int array
     * @return sorted array
     */
    public int[] sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}





package ru.job4j.array;

/**
 * Turn
 * turn array
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.2
 * @version 1.0
 * @since 10.10.2018
 */
public class Turn {
    /**
     * method turn array
     *
     * @param array any int array
     * @return turned array
     */
    public int[] turn(int[] array) {
        int temp;
        for (int index = 0; index < (array.length / 2); index++) {
            temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}





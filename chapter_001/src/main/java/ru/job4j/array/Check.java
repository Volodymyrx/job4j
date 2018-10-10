package ru.job4j.array;

/**
 * Check
 * check array
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.3
 * @version 1.0
 * @since 10.10.2018
 */
public class Check {
    /**
     * method mono check array by all it items true
     *
     * @param data any boolean array
     * @return true if all items are true
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean first = data[0];
        for (boolean aData : data) {
            if (aData != first) {
                result = false;
                break;
            }
        }
        return result;
    }
}





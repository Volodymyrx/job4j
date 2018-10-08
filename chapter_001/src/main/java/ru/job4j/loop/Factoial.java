package ru.job4j.loop;

/**
 * Factorial
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.2
 * @version 1.0
 * @since 08.10.2018
 */
public class Factoial {
    /**
     * method counting factorial
     *
     * @param n is int numbers.
     * @return factorial
     */
    public int calc(int n) {
        int factor = 1;
        for (int i = 1; i <= n; i++) {
            factor *= i;
        }
        return factor;
    }


}

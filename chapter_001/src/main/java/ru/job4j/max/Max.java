package ru.job4j.max;

/**
 * Max
 * between two int
 * between three int
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.4
 * @version 1.0
 * @since 08.10.2018
 */
public class Max {

    /**
     * max between two number int
     *
     * @param first and int second any numbers int.
     * @return int number is biggest
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * max between three number int
     *
     * @param first second and third any numbers int.
     * @return int number is biggest
     */
    public int max(int first, int second, int third) {
        int temp = max(first, second);
        return max(temp, third);
    }
}
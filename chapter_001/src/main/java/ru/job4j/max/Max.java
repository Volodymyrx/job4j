package ru.job4j.max;

/**
 * Max betwin two int
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.2
 * @version 1.0
 * @since 08.10.2018
 */
public class Max {

    /**
     * Отвечает на вопросы.
     *
     * @param first and int second any numbers int.
     * @return int number is biggest
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
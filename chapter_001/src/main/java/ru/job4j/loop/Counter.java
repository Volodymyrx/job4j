package ru.job4j.loop;

/**
 * Counter
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.1
 * @version 1.0
 * @since 08.10.2018
 */
public class Counter {

    /**
     * method counting the sum of even numbers
     * counting from start to finish number
     *
     * @param start and finish int numbers.
     * @return summ of even numbers.
     */
    public int add(int start, int finish) {
        //определяем какое из чисел меньше
        int minNumber = start;
        int maxNumber = finish;
        int sum = 0;
        if (start > finish) {
            minNumber = finish;
            maxNumber = start;
        }
        while (minNumber <= maxNumber) {
            if (minNumber % 2 == 0) {
                sum += minNumber;
            }
            minNumber++;
        }
        return sum;
    }
}

package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Paint
 * painting piramid
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.5
 * @version 1.0
 * @since 09.10.2018
 */
public class Paint {

    /**
     * method rightTrl paint right part of piramid
     *
     * @param height height of piramid
     * @return string with image piramid
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * method leftTrl paint left part of piramid
     *
     * @param height height of piramid
     * @return string with image piramid
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * method paint piramid
     *
     * @param height height of piramid
     * @return string with image piramid
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * method loopBy is inner part of another methods
     *
     * @param height height of piramid, and any
     * @return string with image piramid
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}

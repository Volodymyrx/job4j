package ru.job4j.tracker;

/**
 * itarface Input
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 2.2
 * @version 1.0
 * @since 16.10.2018
 */
public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}

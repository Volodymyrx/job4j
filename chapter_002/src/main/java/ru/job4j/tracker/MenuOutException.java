package ru.job4j.tracker;

/**
 * MenuOutException
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.1
 * @version 1.0
 * @since 24.10.2018
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}

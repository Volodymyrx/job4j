package ru.job4j.chess;

/**
 * FigureNotException
 * part of project chess
 * throw if figure is not in sourse cell
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 002.8
 * @version 1.0
 * @since 30.10.2018
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String message) {
        super(message);
    }
}

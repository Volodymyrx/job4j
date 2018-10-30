package ru.job4j.chess;

/**
 * ImpossibleMoveException
 * part of project chess
 * throw if figure ipossible move this way
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 002.8
 * @version 1.0
 * @since 30.10.2018
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String message) {
        super(message);
    }
}

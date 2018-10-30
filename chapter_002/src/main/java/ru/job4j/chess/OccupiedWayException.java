package ru.job4j.chess;

/**
 * OccupiedWayException
 * part of project chess
 * throw if the way of move this figur is occupied
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 002.8
 * @version 1.0
 * @since 30.10.2018
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String message) {
        super(message);
    }
}

package ru.job4j.shape;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Square
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.4
 * @version 1.0
 * @since 19.10.2018
 */

public class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("sssssss")
                        .add("sssssss")
                        .add("sssssss")
                        .add("sssssss")
                        .toString()
                )
        );
    }
}

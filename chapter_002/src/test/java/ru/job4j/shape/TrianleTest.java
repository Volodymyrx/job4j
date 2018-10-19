package ru.job4j.shape;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Triangle
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.4
 * @version 1.0
 * @since 19.10.2018
 */

public class TrianleTest {

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("   t   ")
                        .add("  ttt  ")
                        .add(" ttttt ")
                        .add("ttttttt")
                        .toString()
                )
        );
    }
}

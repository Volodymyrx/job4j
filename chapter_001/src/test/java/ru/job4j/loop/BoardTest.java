package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BoardTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.3
 * @version 1.0
 * @since 08.10.2018
 */

public class BoardTest {
    @Test
    public void when3x3() {
        Board board = new Board();
        String rsl = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)
                )
        );
    }

    @Test
    public void when4x4() {
        Board board = new Board();
        String rsl = board.paint(4, 4);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X %s X X%sX X %s X X%s", ln, ln, ln, ln)
                )
        );
    }


}

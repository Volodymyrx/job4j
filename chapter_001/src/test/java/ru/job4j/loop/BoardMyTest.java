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

public class BoardMyTest {
    @Test
    public void when3x3() {
        BoardMy board = new BoardMy();
        String rsl = board.paintMy(3, 3);
        assertThat(rsl, is("X X\n X \nX X\n"));
    }

    @Test
    public void when4x4() {
        BoardMy board = new BoardMy();
        String rsl = board.paintMy(4, 4);
        assertThat(rsl, is("X X \n X X\nX X \n X X\n"));
    }


}

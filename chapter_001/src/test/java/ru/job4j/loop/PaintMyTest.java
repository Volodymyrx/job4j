package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PaintMyTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.4
 * @version 1.0
 * @since 09.10.2018
 */

public class PaintMyTest {
    @Test
    public void whenH3() {
        PaintMy paintMy = new PaintMy();
        String rsl = paintMy.piramid(3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("  ^  %s ^^^ %s^^^^^%s", ln, ln, ln)
                )
        );
    }


    @Test
    public void whenH4() {
        PaintMy paintMy = new PaintMy();
        String rsl = paintMy.piramid(4);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("   ^   %s  ^^^  %s ^^^^^ %s^^^^^^^%s", ln, ln, ln, ln)
                )
        );
    }


}

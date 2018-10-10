package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayChar
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.4
 * @version 1.0
 * @since 10.10.2018
 */
public class ArrayCharTest {

    @Test
    public void ifPrefixTrueThenTrue() {
        ArrayChar arrayChar = new ArrayChar("Hello");
        assertThat(arrayChar.startWith("Hel"), is(true));
    }

    @Test
    public void ifPrefixFalseThenFalse() {
        ArrayChar arrayChar = new ArrayChar("Hello");
        assertThat(arrayChar.startWith("Hee"), is(false));
    }

    @Test
    public void ifPrefixTooLongThenFalse() {
        ArrayChar arrayChar = new ArrayChar("Hello");
        assertThat(arrayChar.startWith("Helloo"), is(false));
    }

}

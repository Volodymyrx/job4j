package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Factorial
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.2
 * @version 1.0
 * @since 08.10.2018
 */
public class FactorialTest {

    @Test
    public void whenNumberIs5Then120() {
        Factoial factoial = new Factoial();
        int result = factoial.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenNumberIsZiroThenOne() {
        Factoial factoial = new Factoial();
        int result = factoial.calc(0);
        assertThat(result, is(1));
    }

}

package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.4
 * @version 1.0
 * @since 08.10.2018
 */
public class MaxTest {


    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstBiggest() {
        Max maxim = new Max();
        int result = maxim.max(2, 1, -3);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondBiggest() {
        Max maxim = new Max();
        int result = maxim.max(2, 4, -3);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdBiggest() {
        Max maxim = new Max();
        int result = maxim.max(2, 1, 3);
        assertThat(result, is(3));
    }
}
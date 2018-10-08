package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Counter
 * counting the sum of even numbers
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.1
 * @version 1.0
 * @since 08.10.2018
 */
public class CounterTest {

    @Test
    public void whenFirstLessSecond() {
        Counter counter = new Counter();
        int result = counter.add(4, 10);
        assertThat(result, is(28));
    }

    @Test
    public void whenSecondLessFirst() {
        Counter counter = new Counter();
        int result = counter.add(12, 6);
        assertThat(result, is(36));
    }
}

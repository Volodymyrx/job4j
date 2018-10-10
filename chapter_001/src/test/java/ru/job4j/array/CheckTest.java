package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CheckTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.3
 * @version 1.0
 * @since 10.10.2018
 */
public class CheckTest {

    @Test
    public void controlCheckSomeTrue() {
        Check check = new Check();
        boolean[] inputArray = new boolean[]{true, false, true};
        assertThat(check.mono(inputArray), is(false));
    }

    @Test
    public void controlCheckAllTrue() {
        Check check = new Check();
        boolean[] inputArray = new boolean[]{true, true, true, true};
        assertThat(check.mono(inputArray), is(true));
    }

    @Test
    public void controlCheckAllFalse() {
        Check check = new Check();
        boolean[] inputArray = new boolean[]{false, false, false};
        assertThat(check.mono(inputArray), is(true));
    }
}

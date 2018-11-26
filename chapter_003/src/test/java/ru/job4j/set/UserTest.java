package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class UserTest
 * project lesson 3.3.1
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 26.11.2018
 */
public class UserTest {

    /**
     * public void compareTo()
     */
    @Test
    public void whenLeftAgeBigestThenTrue() {
        User leftUser = new User("Anton", 25);
        User rightUser = new User("zBoris", 20);
        boolean result = leftUser.compareTo(rightUser) > 0;
        assertThat(result, is(true));
    }

    @Test
    public void whenRightAgeBigestThenTrue() {
        User leftUser = new User("Anton", 25);
        User rightUser = new User("zBoris", 30);
        boolean result = leftUser.compareTo(rightUser) < 0;
        assertThat(result, is(true));
    }

    @Test
    public void whenAgeEquelBigestNameLeftThenTrue() {
        User leftUser = new User("Anton", 25);
        User rightUser = new User("zBoris", 25);
        boolean result = leftUser.compareTo(rightUser) < 0;
        assertThat(result, is(true));
    }

    @Test
    public void whenAgeEquelBigestNameRightThenTrue() {
        User leftUser = new User("zAnton", 25);
        User rightUser = new User("Boris", 25);
        boolean result = leftUser.compareTo(rightUser) > 0;
        assertThat(result, is(true));
    }

    @Test
    public void whenEquelThenTrue() {
        User leftUser = new User("Zzzzz", 25);
        User rightUser = new User("Zzzzz", 25);
        boolean result = leftUser.compareTo(rightUser) == 0;
        assertThat(result, is(true));
    }
}
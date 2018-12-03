package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * task-bank test
 * class UserTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lessons 3.5.2
 * @version 1.0
 * @since 02.12.2018
 */
public class UserTest {
    /**
     * public void equals() {
     */
    @Test
    public void whenUserThisAndThsiThenTrue() {
        User user1 = new User("Vasia", "FF234321");
        assertThat(user1.equals(user1), is(true));
    }

    @Test
    public void whenUserOneAndOneThenTrue() {
        User user1 = new User("Vasia", "FF234321");
        User user2 = new User("Vasia", "FF234321");
        assertThat(user1.equals(user2), is(true));
    }

    @Test
    public void whenUserOneAndOtherNameThenFalse() {
        User user1 = new User("Vasia", "FF234321");
        User user2 = new User("Kolia", "FF234321");
        assertThat(user1.equals(user2), is(false));
    }

    @Test
    public void whenUserOneAndOtherPassportThenFalse() {
        User user1 = new User("Vasia", "FF234321");
        User user2 = new User("Vasia", "aF234321");
        assertThat(user1.equals(user2), is(false));
    }

    @Test
    public void whenUserOneAndOtherNullThenFalse() {
        User user1 = new User("Vasia", "FF234321");
        User user2 = null;
        assertThat(user1.equals(user2), is(false));
    }

    @Test
    public void whenUserOneAndOtherClassThenFalse() {
        User user1 = new User("Vasia", "FF234321");
        String stringUser2 = "Other";
        assertThat(user1.equals(stringUser2), is(false));
    }


}





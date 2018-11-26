package ru.job4j.set;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class SortUserTest
 * project lesson 3.3.1
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 25.11.2018
 */
public class SortUserTest {
    @Test
    public void whenListUserInTreeSetThenMapThreeUser() {
        SortUser sortUser = new SortUser();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Ivan", 21));
        listUser.add(new User("Abraham", 20));
        listUser.add(new User("Ben", 25));
        listUser.add(new User("Ben", 21));
        Set<User> setUser = sortUser.sort(listUser);
        assertThat(setUser.toString(), is("" +
                "[User{name='Abraham', age=20}, " +
                "User{name='Ben', age=21}, " +
                "User{name='Ivan', age=21}, " +
                "User{name='Ben', age=25}]"
        ));
    }
}
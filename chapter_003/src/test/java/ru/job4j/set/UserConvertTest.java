package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class UserConvertTest
 * project lesson 3.3.2
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 24.11.2018
 */
public class UserConvertTest {
    @Test
    public void whenThreeUserInArrayThenMapThreeUser() {
        UserConvert userConvert = new UserConvert();

        List<User> listUser = new ArrayList<>();
        listUser.add(new User(1111, "Vasia", "Odessa"));
        listUser.add(new User(2222, "Ivan", "Moscow"));
        listUser.add(new User(3333, "Kola", "Ufa"));
        Map<Integer, User> mapUser = userConvert.process(listUser);
        assertThat(mapUser.get(2222).getName(), is("Ivan"));
    }
}
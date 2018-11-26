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
    /**
     * assertThat(setUser.toString(), is( -  как сделать без String? как можно проверить сеты?
     */
    @Test
    public void whenListUserInTreeSetThenOkNew() {
        SortUser sortUser = new SortUser();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Ivan", 21));
        listUser.add(new User("Abraham", 20));
        listUser.add(new User("Ben", 25));
        listUser.add(new User("Ben", 21));
        Set<User> setUser = sortUser.sort(listUser);
        Iterator<User> it = setUser.iterator();
        int age1 = it.next().getAge();
        int age2 = it.next().getAge();
        int age3 = it.next().getAge();
        int age4 = it.next().getAge();
        boolean result = (age1 <= age2) && (age2 <= age3) && (age3 <= age4);
        assertThat(result, is(true));
    }


    @Test
    public void whenListUserInTreeSetThenMapThreeUser() {
        SortUser sortUser = new SortUser();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Ivan", 21));
        listUser.add(new User("Abraham", 20));
        listUser.add(new User("Ben", 25));
        listUser.add(new User("Ben", 21));
        Set<User> setUser = sortUser.sort(listUser);
        assertThat(setUser.toString(), is(""
                + "[User{name='Abraham', age=20}, "
                + "User{name='Ben', age=21}, "
                + "User{name='Ivan', age=21}, "
                + "User{name='Ben', age=25}]"
        ));
    }

    /**
     * public List<User> sortNameLength (List<User> list)
     */
    @Test
    public void whenListThenSortedLength() {
        SortUser sortUser = new SortUser();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Ivan", 21));
        listUser.add(new User("Abraham", 20));
        listUser.add(new User("Li", 25));
        listUser.add(new User("Ben", 30));
        assertThat(sortUser.sortNameLength(listUser).toString(), is(""
                + "[User{name='Li', age=25}, "
                + "User{name='Ben', age=30}, "
                + "User{name='Ivan', age=21}, "
                + "User{name='Abraham', age=20}]"
        ));
    }

    /**
     * public List<User> sortByAllFields (List<User>)
     */
    @Test
    public void whenListThenSortedNameAge() {
        SortUser sortUser = new SortUser();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Ivan", 21));
        listUser.add(new User("Abraham", 20));
        listUser.add(new User("Livenson", 25));
        listUser.add(new User("Ivan", 18));
        assertThat(sortUser.sortByAllFields(listUser).toString(), is(""
                + "[User{name='Abraham', age=20}, "
                + "User{name='Ivan', age=18}, "
                + "User{name='Ivan', age=21}, "
                + "User{name='Livenson', age=25}]"
        ));
    }
}
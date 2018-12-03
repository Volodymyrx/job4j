package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * task-bank test
 * class AccountTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lessons 3.5.2
 * @version 1.0
 * @since 02.12.2018
 */
public class AccountTest {
    /**
     * public void equals() {
     */
    @Test
    public void whenAccountThisAndThisThenTrue() {
        Account account1 = new Account("aaa444");
        assertThat(account1.equals(account1), is(true));
    }

    @Test
    public void whenTwoAccountEqualsThenTrue() {
        Account account1 = new Account("aaa444");
        Account account2 = new Account("aaa444");
        assertThat(account1.equals(account2), is(true));
    }

    @Test
    public void whenTwoAccountNoEqualsThenFalse() {
        Account account1 = new Account("aaa444");
        Account account2 = new Account("aaa445");
        assertThat(account1.equals(account2), is(false));
    }

    @Test
    public void whenTwoAccountEqualsValueThenTrue() {
        Account account1 = new Account("aaa444");
        account1.setValue(100);
        Account account2 = new Account("aaa444");
        account2.setValue(200);
        assertThat(account1.equals(account2), is(true));
    }

    @Test
    public void whenTwoAccountEqualsValueReversThenTrue() {
        Account account1 = new Account("aaa4444");
        account1.setValue(100);
        Account account2 = new Account("aaa4444");
        account2.setValue(200);
        assertThat(account2.equals(account1), is(true));
    }
}
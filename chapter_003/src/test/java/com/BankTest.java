package com;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {
    //    public boolean transfer(com.User user1, Account account1,
//                            com.User user2, Account account2, double amount) {
    @Test
    public void whenThreeUserInArrayThenMapThreeUser() {
        Bank bank = new Bank();
        com.User user1 = new com.User(111, "Vasia");
        bank.addUser(user1);
        Account account11 = new Account(100, "aaa");
        Account account12 = new Account(200, "bbb");
        bank.add(user1, account11);
        bank.add(user1, account12);
        com.User user2 = new com.User(222, "Kolia");
        bank.addUser(user2);
        Account account21 = new Account(1000, "ccc");
        Account account22 = new Account(2000, "yyy");
        bank.add(user2, account21);
        bank.add(user2, account22);
        bank.transfer(user1, account11, user2, account22, 55);
        assertThat(account11.getValues(), is(45.0));
    }
}
package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * task-bank test
 * class BankTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lessons 3.5.2
 * @version 1.0
 * @since 02.12.2018
 */
public class BankTest {
    private final String ln = System.lineSeparator();

    /**
     * public void addUser(User user)
     */
    @Test
    public void whenAddNewUserThenAddedNewUser() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        bank.addUser(user1);
        assertThat(bank.bankToString(), is("Bank all users: " + ln + "Name of User is: Vasia" + ln + ln));
    }

    @Test
    public void whenAddThreeNewUserThenAddedThreeNewUser() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        User user2 = new User("Ivan", "FF234323");
        User user3 = new User("Karl", "FF234325");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
        assertThat(bank.bankToString(), is("Bank all users: " + ln
                + "Name of User is: Ivan" + ln + ln
                + "Name of User is: Karl" + ln + ln
                + "Name of User is: Vasia" + ln + ln));
    }

    @Test
    public void whenAddFourRepeatNewUserThenAddedTwoNewUser() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        User user2 = new User("Ivan", "FF234323");
        User user21 = new User("Ivan", "FF234323");
        User user3 = new User("Karl", "FF234325");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user21);
        bank.addUser(user3);
        assertThat(bank.bankToString(), is("Bank all users: " + ln
                + "Name of User is: Ivan" + ln + ln
                + "Name of User is: Karl" + ln + ln
                + "Name of User is: Vasia" + ln + ln));
    }

    /**
     * public void deleteUser(User user) {
     */
    @Test
    public void whenDelateUserThenTwoUser() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        User user2 = new User("Ivan", "FF234323");
        User user3 = new User("Karl", "FF234325");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
        bank.deleteUser(user2);
        assertThat(bank.bankToString(), is("Bank all users: " + ln
                + "Name of User is: Karl" + ln + ln
                + "Name of User is: Vasia" + ln + ln));
    }

    @Test
    public void whenDelateAllOverUserThenNothing() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        User user2 = new User("Ivan", "FF234323");
        User user3 = new User("Karl", "FF234325");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
        bank.deleteUser(user2);
        bank.deleteUser(user3);
        bank.deleteUser(user3);
        bank.deleteUser(user1);
        bank.deleteUser(user1);
        assertThat(bank.bankToString(), is("Bank all users: " + ln));
    }

    /**
     * public void addAccountToUser(String passport, Account account)
     */
    @Test
    public void whenAddAccauntThenAddedAccaunt() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        bank.addUser(user1);
        Account account = new Account("anyRequsits123");
        account.setValue(101);
        bank.addAccountToUser("FF234321", account);
        account.setValue(account.getValue() + 55000);
        assertThat(bank.userToString(user1), is("Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 55101.0 $ USA" + ln));
    }

    @Test
    public void whenAddTwoAccauntThenAddedTwoAccaunt() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        bank.addUser(user1);
        Account account = new Account("anyRequsits123");
        account.setValue(101);
        bank.addAccountToUser("FF234321", account);
        account.setValue(account.getValue() + 55000);
        Account account2 = new Account("anyRequsits555");
        account2.setValue(102000);
        bank.addAccountToUser("FF234321", account2);
        assertThat(bank.userToString(user1), is("Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 55101.0 $ USA" + ln
                + "account is: anyRequsits555 value is: $ 102000.0 $ USA" + ln));
    }

    @Test
    public void whenAddFiveAccauntThenAddedTwoAccaunt() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        bank.addUser(user1);
        Account account = new Account("anyRequsits123");
        account.setValue(101);
        bank.addAccountToUser("FF234321", account);
        account.setValue(account.getValue() + 55000);
        Account account2 = new Account("anyRequsits555");
        account2.setValue(102000);
        bank.addAccountToUser("FF234321", account2);
        bank.addAccountToUser("FF234321", account2);
        bank.addAccountToUser("FF234321", account);
        Account account3 = new Account("anyRequsits555");
        account3.setValue(1000000);
        bank.addAccountToUser("FF234321", account3);
        assertThat(bank.userToString(user1), is("Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 55101.0 $ USA" + ln
                + "account is: anyRequsits555 value is: $ 102000.0 $ USA" + ln));
    }

    /**
     * public void deleteAccountFromUser(String passport, Account account)
     */
    @Test
    public void whenDeleteAccauntThenDeletedAccaunt() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        bank.addUser(user1);
        Account account = new Account("anyRequsits123");
        account.setValue(101);
        bank.addAccountToUser("FF234321", account);
        account.setValue(account.getValue() + 55000);
        Account account2 = new Account("anyRequsits555");
        account2.setValue(102000);
        bank.addAccountToUser("FF234321", account2);
        bank.deleteAccountFromUser("FF234321", account);
        assertThat(bank.userToString(user1), is("Name of User is: Vasia" + ln
                + "account is: anyRequsits555 value is: $ 102000.0 $ USA" + ln));
    }

    /**
     * public List<Account> getUserAccounts(String passport)
     */
    @Test
    public void whenZiroAccauntThen0() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        bank.addUser(user1);
        assertThat(bank.getUserAccounts("FF234321").size(), is(0));
    }

    @Test
    public void whenTwoAccauntThen2() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        bank.addUser(user1);
        Account account = new Account("anyRequsits123");
        account.setValue(101);
        bank.addAccountToUser("FF234321", account);
        account.setValue(account.getValue() + 55000);
        Account account2 = new Account("anyRequsits555");
        account2.setValue(102000);
        bank.addAccountToUser("FF234321", account2);
        assertThat(bank.getUserAccounts("FF234321").size(), is(2));
    }

    /**
     * public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount)
     */
    @Test
    public void whenTransferHimselfThenOk() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        bank.addUser(user1);
        Account account = new Account("anyRequsits123");
        account.setValue(100);
        bank.addAccountToUser("FF234321", account);
        Account account2 = new Account("anyRequsits555");
        account2.setValue(200);
        bank.addAccountToUser("FF234321", account2);
        boolean isOk = bank.transferMoney("FF234321", "anyRequsits123", "FF234321", "anyRequsits555", 10);
        String result = bank.userToString(user1) + isOk;
        assertThat(result, is("Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 90.0 $ USA" + ln
                + "account is: anyRequsits555 value is: $ 210.0 $ USA" + ln
                + "true"));
    }

    @Test
    public void whenTransferTwoUserOkThenOk() {
        Bank bank = uploadTwoUserToTwoAccount();
        boolean isOk = bank.transferMoney("FF234321", "anyRequsits123", "AA234321", "anyRequsits777", 20);
        String result = bank.bankToString() + isOk;
        assertThat(result, is("Bank all users: " + ln
                + "Name of User is: Ivan" + ln
                + "account is: anyRequsits124 value is: $ 300.0 $ USA" + ln
                + "account is: anyRequsits777 value is: $ 420.0 $ USA" + ln + ln
                + "Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 80.0 $ USA" + ln
                + "account is: anyRequsits555 value is: $ 200.0 $ USA" + ln + ln
                + "true"));
    }

    @Test
    public void whenTransferAllValueThenOkZiro() {
        Bank bank = uploadTwoUserToTwoAccount();
        boolean isOk = bank.transferMoney("FF234321", "anyRequsits123", "AA234321", "anyRequsits777", 100);
        String result = bank.bankToString() + isOk;
        assertThat(result, is("Bank all users: " + ln
                + "Name of User is: Ivan" + ln
                + "account is: anyRequsits124 value is: $ 300.0 $ USA" + ln
                + "account is: anyRequsits777 value is: $ 500.0 $ USA" + ln + ln
                + "Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 0.0 $ USA" + ln
                + "account is: anyRequsits555 value is: $ 200.0 $ USA" + ln + ln
                + "true"));
    }

    @Test
    public void whenTransferOverValueThenFalse() {
        Bank bank = uploadTwoUserToTwoAccount();
        boolean isOk = bank.transferMoney("FF234321", "anyRequsits123", "AA234321", "anyRequsits777", 8888);
        String result = bank.bankToString() + isOk;
        assertThat(result, is("Bank all users: " + ln
                + "Name of User is: Ivan" + ln
                + "account is: anyRequsits124 value is: $ 300.0 $ USA" + ln
                + "account is: anyRequsits777 value is: $ 400.0 $ USA" + ln + ln
                + "Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 100.0 $ USA" + ln
                + "account is: anyRequsits555 value is: $ 200.0 $ USA" + ln + ln
                + "false"));
    }

    @Test
    public void whenTransferFalseUserThenFalse() {
        Bank bank = uploadTwoUserToTwoAccount();
        boolean isOk = bank.transferMoney("FsssF234321", "anyRequsits123", "AA234321", "anyRequsits777", 88);
        String result = bank.bankToString() + isOk;
        assertThat(result, is("Bank all users: " + ln
                + "Name of User is: Ivan" + ln
                + "account is: anyRequsits124 value is: $ 300.0 $ USA" + ln
                + "account is: anyRequsits777 value is: $ 400.0 $ USA" + ln + ln
                + "Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 100.0 $ USA" + ln
                + "account is: anyRequsits555 value is: $ 200.0 $ USA" + ln + ln
                + "false"));
    }

    @Test
    public void whenTransferFalseUserDestThenFalse() {
        Bank bank = uploadTwoUserToTwoAccount();
        boolean isOk = bank.transferMoney("FF234321", "anyRequsits123", "AsssA234321", "anyRequsits777", 88);
        String result = bank.bankToString() + isOk;
        assertThat(result, is("Bank all users: " + ln
                + "Name of User is: Ivan" + ln
                + "account is: anyRequsits124 value is: $ 300.0 $ USA" + ln
                + "account is: anyRequsits777 value is: $ 400.0 $ USA" + ln + ln
                + "Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 100.0 $ USA" + ln
                + "account is: anyRequsits555 value is: $ 200.0 $ USA" + ln + ln
                + "false"));
    }

    @Test
    public void whenTransferFalseRequisiteSrcThenFalse() {
        Bank bank = uploadTwoUserToTwoAccount();
        boolean isOk = bank.transferMoney("FF234321", "aYYYnyRequsits123", "AA234321", "anyRequsits777", 88);
        String result = bank.bankToString() + isOk;
        assertThat(result, is("Bank all users: " + ln
                + "Name of User is: Ivan" + ln
                + "account is: anyRequsits124 value is: $ 300.0 $ USA" + ln
                + "account is: anyRequsits777 value is: $ 400.0 $ USA" + ln + ln
                + "Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 100.0 $ USA" + ln
                + "account is: anyRequsits555 value is: $ 200.0 $ USA" + ln + ln
                + "false"));
    }

    @Test
    public void whenTransferFalseRequisiteDestThenFalse() {
        Bank bank = uploadTwoUserToTwoAccount();
        boolean isOk = bank.transferMoney("FF234321", "anyRequsits123", "AA234321", "anyRYYYequsits777", 88);
        String result = bank.bankToString() + isOk;
        assertThat(result, is("Bank all users: " + ln
                + "Name of User is: Ivan" + ln
                + "account is: anyRequsits124 value is: $ 300.0 $ USA" + ln
                + "account is: anyRequsits777 value is: $ 400.0 $ USA" + ln + ln
                + "Name of User is: Vasia" + ln
                + "account is: anyRequsits123 value is: $ 100.0 $ USA" + ln
                + "account is: anyRequsits555 value is: $ 200.0 $ USA" + ln + ln
                + "false"));
    }


    /**
     * util method for upload two users with two accounts for continion testing
     *
     * @return bank with users and account
     */
    private Bank uploadTwoUserToTwoAccount() {
        Bank bank = new Bank();
        User user1 = new User("Vasia", "FF234321");
        bank.addUser(user1);
        Account account11 = new Account("anyRequsits123");
        account11.setValue(100);
        bank.addAccountToUser("FF234321", account11);
        Account account12 = new Account("anyRequsits555");
        account12.setValue(200);
        bank.addAccountToUser("FF234321", account12);
        User user2 = new User("Ivan", "AA234321");
        bank.addUser(user2);
        Account account21 = new Account("anyRequsits124");
        account21.setValue(300);
        bank.addAccountToUser("AA234321", account21);
        Account account22 = new Account("anyRequsits777");
        account22.setValue(400);
        bank.addAccountToUser("AA234321", account22);
        return bank;
    }
}
package ru.job4j.bank;

import java.util.*;

/**
 * task-bank
 * class Bank
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lessons 3.5.2
 * @version 1.0
 * @since 02.12.2018
 */
public class Bank {
    /**
     * набор пользователей со своими счетами
     * у каждого пользователя может быть список банковских счетов
     */
    private final Map<User, List<Account>> usersAccounts = new TreeMap<>();
    /**
     * перенос сторки для отображения
     */
    private final String ln = System.lineSeparator();

    /**
     * добавление пользователя
     *
     * @param user user(name,passport)
     */
    public void addUser(User user) {
        this.usersAccounts.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * удаление пользователя
     *
     * @param user user
     */
    public void deleteUser(User user) {
        this.usersAccounts.remove(user);
    }

    /**
     * добавить счёт пользователю
     *
     * @param passport of user
     * @param account  exist account
     */
    public void addAccountToUser(String passport, Account account) {
        User user = getUserByPassport(passport);
        List<Account> accounts = getUserAccounts(passport);
        if ((accounts != null) && (user != null) && (accounts.indexOf(account) == -1)) {
            this.usersAccounts.get(user).add(account);
        }
    }

    /**
     * util method for search user by passport
     *
     * @param passport of user
     * @return user if found and null if not found
     */
    private User getUserByPassport(String passport) {
        User userRes = null;
        for (User user : usersAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                userRes = user;
                break;
            }
        }
        return userRes;
    }

    /**
     * удалить один счёт пользователя
     *
     * @param passport of user
     * @param account  user add by user
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = getUserByPassport(passport);
        if (user != null) {
            usersAccounts.get(user).remove(account);
        }
    }

    /**
     * получить список счетов для пользователя
     *
     * @param passport of user
     * @return list of accont of user
     */
    public List<Account> getUserAccounts(String passport) {
        User user = getUserByPassport(passport);
        List<Account> accounts = null;
        if (user != null) {
            accounts = usersAccounts.get(user);
        }
        return accounts;
    }

    /**
     * метод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
     *
     * @param srcPassport  passport first user
     * @param srcRequisite of account first user
     * @param destPassport passport second user
     * @param dstRequisite requisite of account second user
     * @param amount       sum of money to get from first user and put to second user
     * @return if ok true
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean isOk = false;
        Account srcAccount = getAccountByPassportRequisite(srcPassport, srcRequisite);
        Account destAccount = getAccountByPassportRequisite(destPassport, dstRequisite);
        if (srcAccount != null && destAccount != null) {
            if (srcAccount.getValue() >= amount) {
                srcAccount.setValue(srcAccount.getValue() - amount);
                destAccount.setValue(destAccount.getValue() + amount);
                isOk = true;
            }
        }
        return isOk;
    }

    /**
     * util method search account of usera by passport and requsite
     *
     * @param passport  of user
     * @param requisite of account
     * @return accoutn of user
     */
    private Account getAccountByPassportRequisite(String passport, String requisite) {
        Account resultAccount = null;
        List<Account> accounts = getUserAccounts(passport);
        if (accounts != null) {
            for (Account account : accounts) {
                if (account.getRequisites().equals(requisite)) {
                    resultAccount = account;
                    break;
                }
            }
        }
        return resultAccount;
    }


    /**
     * util method for control all accounts of all users
     *
     * @return string about all users and all account
     */
    public String bankToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bank all users: ").append(ln);
        for (User user : usersAccounts.keySet()) {
            sb.append(userToString(user)).append(ln);
        }
        return sb.toString();
    }

    /**
     * util method for control accounts of user
     *
     * @param user some user
     * @return string about all acounts of user
     */
    public String userToString(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("Name of User is: ").append(user.getName()).append(ln);
        if (user != null) {
            for (Account account : usersAccounts.get(user)) {
                sb.append("account is: ").append(account.getRequisites()).append(" value is: $ ").append(account.getValue()).append(" $ USA").append(ln);
            }
        }
        return sb.toString();
    }
//    Посмотрите на методы Map.putIfAbsent и List.indexOf, как их можно применить в этом задании.
}

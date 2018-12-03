package ru.job4j.bank;

import java.util.Objects;

/**
 * task-bank
 * class Account
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lessons 3.5.2
 * @version 1.0
 * @since 02.12.2018
 */
public class Account {
    /**
     * количество денег
     */
    private double value;
    /**
     * (реквизиты счёта) - это банковский счёт
     */
    private final String requisites;

    public Account(String requisites) {
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else {
            if (o != null) {
                if (getClass() == o.getClass()) {
                    Account account = (Account) o;
                    if (this.requisites.equals(account.getRequisites())) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}

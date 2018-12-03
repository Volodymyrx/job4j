package ru.job4j.bank;

import java.util.Objects;

/**
 * task-bank
 * class User
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lessons 3.5.2
 * @version 1.0
 * @since 02.12.2018
 */
public class User implements Comparable {
    private final String name;
    private final String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else {
            if (o != null) {
                if (getClass() == o.getClass()) {
                    User user = (User) o;
                    if (this.name.equals(user.getName())) {
                        if (this.getPassport().equals(user.getPassport())) {
                            result = true;
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((User) o).getName());
    }
}

package ru.job4j.list;

/**
 * class User
 * project lesson 3.3.2
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 24.11.2018
 */
public class User {

    private final Integer id;
    private final String city;
    private final String name;


    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

}

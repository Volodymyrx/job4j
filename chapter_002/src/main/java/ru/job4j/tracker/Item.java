package ru.job4j.tracker;

/**
 * Item
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 2.3
 * @version 1.0
 * @since 17.10.2018
 */

public class Item {
    private String id;
    private String name;
    private String desctiption;

    /**
     * constructor with 2 param
     *
     * @param name - name of Item
     * @param desctiption - description of Item
     */
    public Item(String name, String desctiption) {
        this.name = name;
        this.desctiption = desctiption;
    }

    /**
     * constructor with 3 param
     *
     * @param id - unic id of Item- String
     * @param name - name of Item
     * @param desctiption - description of Item
     */
    public Item(String id, String name, String desctiption) {
        this.id = id;
        this.name = name;
        this.desctiption = desctiption;
    }

    /**setter field id*/
    public void setId(String generatedId) {
        this.id = generatedId;
    }
    /**getter field id*/
    public String getId() {
        return this.id;
    }
    /**getter field name*/
    public String getName() {
        return this.name;
    }
    /**getter field desription*/
    public String getDesctiption() {
        return desctiption;
    }
}

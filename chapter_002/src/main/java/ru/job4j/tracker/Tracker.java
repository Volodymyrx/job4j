package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Tracker
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 2.2
 * @version 1.0
 * @since 16.10.2018
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /*getter for items*/
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * method add - add unic id in item and add in array
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item is new item for add in array
     * @return item with unic id
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * method generatedId - make unick id String
     *
     * @return unick id String
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * method findById - serch in array by id
     *
     * @param id String - id of item
     * @return item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if ((item != null) && (item.getId().equals(id))) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * method replace - change item in array by id
     *
     * @param id String - id of item, and new item
     */
    public void replace(String id, Item item) {
        item.setId(id);
        for (int i = 0; i < this.items.size(); i++) {
            if ((this.items.get(i).getId().equals(id))) {
                this.items.add(i, item);
                break;
            }
        }
    }

    /**
     * method delete - delete item from array by id
     *
     * @param id String - id of item
     */
    public void delete(String id) {
        for (int i = 0; i < this.items.size(); i++) {
            if ((this.items.get(i).getId().equals(id))) {
                this.items.remove(i);
                break;
            }
        }
    }

    /**
     * method findAll - return copy array Item without null
     *
     * @return copy array Item without null
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * method findByName - return array Item by Name
     *
     * @param key is Name of Item
     * @return array Item by name
     */
    public List<Item> findByName(String key) {
        List<Item> itemNames = new ArrayList<>();
        for (Item item : items) {
            if ((item != null) && (item.getName().equals(key))) {
                itemNames.add(item);
            }
        }
        return itemNames;
    }
}

package ru.job4j.tracker;

import java.util.Arrays;
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
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * method add - add unic id in item and add in array
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item is new item for add in array
     * @return item with unic id
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int i = 0; i < this.position; i++) {
            if ((items[i] != null) && (this.items[i].getId().equals(id))) {
                result = items[i];
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
        for (int i = 0; i < this.position; i++) {
            if ((this.items[i].getId().equals(id))) {
                this.items[i] = item;
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
        for (int i = 0; i < this.position; i++) {
            if ((this.items[i].getId().equals(id))) {
                this.items[i] = null;
                System.arraycopy(this.items, (i + 1), this.items, i, (this.position - (i + 1)));
                this.items[position] = null;
                this.position--;
                break;
            }
        }
    }

    /**
     * method findAll - return copy array Item without null
     *
     * @return copy array Item without null
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * method findByName - return array Item by Name
     *
     * @param key is Name of Item
     * @return array Item by name
     */
    public Item[] findByName(String key) {
        Item[] itemNames = new Item[this.position];
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if ((this.items[i] != null) && (this.items[i].getName().equals(key))) {
                itemNames[count] = this.items[i];
                count++;
            }
        }
        return Arrays.copyOf(itemNames, (count));
    }
}

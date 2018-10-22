package ru.job4j.tracker;

/**
 * interface UserAction
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.2
 * @version 1.0
 * @since 22.10.2018
 */
public interface UserAction {


    /**
     * Метод возвращает ключ опции.
     *
     * @return ключ
     */
    int key();

    /**
     * Основной метод.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню
     */
    String info();
}
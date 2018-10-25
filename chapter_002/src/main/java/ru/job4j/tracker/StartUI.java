package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * StartUI- start file
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 2.2
 * @version 1.0
 * @since 17.10.2018
 */
public class StartUI {

    private final Input input;
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method main - start of programm
     *
     * @param args - nothing
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    /**
     * method init - основное меню в консоли
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask(range.toString(), menu.getNumberAnswer()));
        } while (menu.isStay());
    }
}

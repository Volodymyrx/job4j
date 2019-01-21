package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * StartUI- start file
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.2 lesson 004.1.2
 * @version 2.0
 * @since 21.01.2019
 */
public class StartUI {

    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * method main - start of programm
     *
     * @param args - nothing
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::printf).init();
    }

    /**
     * method init - основное меню в консоли
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask(menu.getRange().toString(), menu.getNumberAnswer()));
        } while (menu.isStay());
    }
}

package ru.job4j.tracker;

import java.util.Scanner;

/**
 * ConsoleInput
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 2.2
 * @version 1.0
 * @since 17.10.2018
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * method ask - возвращает ввод с сонсоли
     *
     * @param question - question fок user
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * method ask - возвращает ввод с сонсоли
     *
     * @param question - question fок user
     * @param range    - int of user
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int i : range) {
            if (i == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range. ");
        }
    }
}

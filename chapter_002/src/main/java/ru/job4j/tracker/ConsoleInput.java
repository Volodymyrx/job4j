package ru.job4j.tracker;

import java.util.Scanner;

/**
 * ConsoleInput
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.3
 * @version 1.2
 * @since 25.10.2018
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
}

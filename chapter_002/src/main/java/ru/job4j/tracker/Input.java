package ru.job4j.tracker;

/**
 * itarface Input
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.3
 * @version 1.1
 * @since 25.10.2018
 */
public interface Input {
    String ask(String question);

    /**
     * method ask - возвращает ввод с сонсоли
     *
     * @param question - question fок user
     * @param range    - int of user
     */
    default int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int i : range) {
            if (i == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range. ");
        }
        return key;
    }
}

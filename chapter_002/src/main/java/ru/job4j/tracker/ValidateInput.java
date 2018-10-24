package ru.job4j.tracker;

/**
 * ValidateInput
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 2.2
 * @version 1.0
 * @since 24.10.2018
 */
public class ValidateInput extends ConsoleInput {
    /**
     * method ask - возвращает ввод с сонсоли
     *
     * @param question - question fок user
     * @param range    - control int of user
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu. ");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again. ");
            }
        } while (invalid);
        return value;
    }
}

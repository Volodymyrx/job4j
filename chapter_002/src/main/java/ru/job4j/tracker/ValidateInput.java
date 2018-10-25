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
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * method ask - возвращает ввод с сонсоли
     *
     * @param question - question for user
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * method ask - возвращает ввод с сонсоли
     *
     * @param question - question fоr user
     * @param range    - control int of user
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}


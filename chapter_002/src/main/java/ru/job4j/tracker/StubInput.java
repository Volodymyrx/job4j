package ru.job4j.tracker;

/**
 * StubInput - fot test, imulate input Console
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 2.2
 * @version 1.0
 * @since 17.10.2018
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * method ask - для тестов имулирует ввод с консоли
     *
     * @param question - question for user
     */
    public String ask(String question) {
        return answers[position++];
    }
}

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
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выйти из трекера.
     */
    private final String[] answers;
    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position = 0;

    public StubInput(final String[] answers) {
        this.answers = answers;
    }

    /**
     * method ask - для тестов имулирует ввод с консоли
     *
     * @param question - question for user
     * @return next part of string array answer
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * method ask - для тестов имулирует ввод с консоли
     *
     * @param question - question for user - don't use
     * @param range    - don't use
     * @return next part of string array answer
     */
    @Override
    public int ask(String question, int[] range) {
        return Integer.valueOf(answers[position++]);
    }


}


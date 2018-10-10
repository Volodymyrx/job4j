package ru.job4j.array;

/**
 * ArrayChar
 * check prefix string
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.4
 * @version 1.0
 * @since 10.10.2018
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинается с префикса
     * если префикс длинее слова то false
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        if (value.length <= data.length) {
            for (int i = 0; i < value.length; i++) {
                if (data[i] != value[i]) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}





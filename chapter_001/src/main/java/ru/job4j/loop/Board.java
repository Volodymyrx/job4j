package ru.job4j.loop;

/**
 * Board
 * painting chess board
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.3
 * @version 1.1
 * @since 08.10.2018
 */
public class Board {
    /**
     * method paint chess board
     *
     * @param width and height is size of board
     * @return chess board
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}

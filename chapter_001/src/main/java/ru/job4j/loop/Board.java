package ru.job4j.loop;

/**
 * Board
 * painting chess board
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.3
 * @version 1.0
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
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
//для визуальной отладки
//    public static void main(String[] args) {
//        Board board = new Board();
//        System.out.println(board.paint(6, 8));
//    }


}

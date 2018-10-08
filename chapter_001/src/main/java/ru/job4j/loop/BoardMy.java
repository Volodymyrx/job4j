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
public class BoardMy {
    /**
     * method paint chess board
     *
     * @param width and height is size of board
     * @return chess board
     */
    public String paintMy(int width, int height) {
        String result = "";
        boolean flagI = true;
        boolean flagJ = true;
        for (int i = 0; i < width; i++) {
            if (flagI) {
                flagJ = true;
                flagI = false;
            } else {
                flagJ = false;
                flagI = true;
            }
            for (int j = 0; j < height; j++) {
                if (flagJ) {
                    result += "X";
                    flagJ = false;
                } else {
                    result += " ";
                    flagJ = true;
                }
            }
            result += "\n";
        }
        return result;
    }
//для визуальной отладки
//    public static void main(String[] args) {
//        BoardMy board = new BoardMy();
//        System.out.println(board.paintMy(6, 8));
//    }
//

}

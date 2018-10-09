package ru.job4j.loop;

/**
 * PaintMy
 * painting piramid
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.4
 * @version 1.0
 * @since 09.10.2018
 */

public class PaintMy {
    /**
     * method paint piramid
     *
     * @param h height of piramid
     * @return string with image piramid
     */
    public String piramid(int h) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        int width = h * 2 - 1;
        int pointLeft = h - 1;
        int pointRight = h - 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < width; j++) {
                // условие проверки, что писать пробел или X
                if ((pointLeft <= j) && (j <= pointRight)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            pointLeft--;
            pointRight++;
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }

////для визуальной отладки
//    public static void main(String[] args) {
//        PaintMy paintPiramid= new PaintMy();
//        System.out.println(paintPiramid.piramid( 4));
//    }


}

package ru.job4j.shape;

/**
 * StartPaint
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.4
 * @version 1.0
 * @since 19.10.2018
 */
public class StartPaint {
    public static void main(String[] args) {
        StartPaint startPaint = new StartPaint();
        Paint paint = new Paint();
        startPaint.consoleTriangle(paint);
        startPaint.consoleSquere(paint);
    }

    /**
     * method go for print in console String Triangle
     *
     * @param paint using any shape
     */
    void consoleTriangle(Paint paint) {
        System.out.println(paint.paintShape(new Triangle()));
    }

    /**
     * method go for print in console String Square
     *
     * @param paint using any shape
     */
    void consoleSquere(Paint paint) {
        System.out.println(paint.paintShape(new Square()));
    }
}

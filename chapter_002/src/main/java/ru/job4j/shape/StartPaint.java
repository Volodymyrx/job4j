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
        startPaint.go();
    }

    /**
     * method go for print in console String
     */
    void go() {
        Paint paint = new Paint();

        paint.setShape(new Triangle());
        System.out.println(paint.paintShape());

        paint.setShape(new Square());
        System.out.println(paint.paintShape());
    }
}

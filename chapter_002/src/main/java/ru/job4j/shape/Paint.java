package ru.job4j.shape;

/**
 * Paint
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.4
 * @version 1.2
 * @since 20.10.2018
 */
public class Paint {
    /**
     * method
     *
     * @param shape any shape Triangle or Square
     * @return string with paint shape
     */
    public String paintShape(Shape shape) {
        return shape.draw();
    }
}

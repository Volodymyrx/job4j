package ru.job4j.shape;

/**
 * Paint
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.4
 * @version 1.0
 * @since 19.10.2018
 */
public class Paint {
    private Shape shape;

    /*setter*/
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * method
     *
     * @return string with paint shape
     */
    public String paintShape() {
        return shape.draw();
    }

}

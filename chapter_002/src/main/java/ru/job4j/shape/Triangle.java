package ru.job4j.shape;

/**
 * Triangle
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.4
 * @version 1.0
 * @since 19.10.2018
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        String ln = System.lineSeparator();
        pic.append("   t   " + ln);
        pic.append("  ttt  " + ln);
        pic.append(" ttttt " + ln);
        pic.append("ttttttt" + ln);
        return pic.toString();
    }
}

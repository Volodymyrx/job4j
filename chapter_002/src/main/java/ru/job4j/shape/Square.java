package ru.job4j.shape;

/**
 * Square
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.4
 * @version 1.0
 * @since 19.10.2018
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        String ln = System.lineSeparator();
        pic.append("sssssss" + ln);
        pic.append("sssssss" + ln);
        pic.append("sssssss" + ln);
        pic.append("sssssss" + ln);
        return pic.toString();
    }
}

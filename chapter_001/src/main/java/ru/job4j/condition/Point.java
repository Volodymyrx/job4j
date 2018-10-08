package ru.job4j.condition;

/**
 * Point
 * It's a class of Point and
 * calculate distance between two points
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 3.4
 * @version 1.0
 * @since 08.10.2018
 */
public class Point {
    //    coordinats of point
    private int x;
    private int y;

    /*getter fild int x */
    public int getX() {
        return x;
    }

    /*getter fild int y */
    public int getY() {
        return y;
    }

    /**
     * constructon with param- coordinate
     *
     * @param x,y koordinate of point
     */
    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    /**
     * method distanceTo calculate distance between two points.
     *
     * @param thatPoint - object class Point.
     * @return double distance between two points.
     */
    public double distanceTo(Point thatPoint) {
        return Math.sqrt((Math.pow((this.x - thatPoint.getX()), 2.0)) + (Math.pow((this.y - thatPoint.getY()), 2.0)));
    }
}

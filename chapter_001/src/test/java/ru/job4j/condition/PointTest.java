package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    Point a = new Point(3, -5);
    Point b = new Point(6, 1);


    @Test
    public void distanceBetweenAB() {
        double distance = a.distanceTo(b);
        assertThat(distance, closeTo(6.8, 0.1));
    }

    @Test
    public void distanceBetweenBA() {
        double distance = b.distanceTo(a);
        assertThat(distance, closeTo(6.8, 0.1));
    }
}
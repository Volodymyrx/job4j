package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Matrix
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.6
 * @version 1.0
 * @since 10.10.2018
 */
public class MatrixTest {

    @Test
    public void checkSortArray() {
        Matrix matrix = new Matrix();
        int[][] expect = new int[][]{
                {1, 2, 3},
                {2, 4, 6},
                {3, 6, 9}
        };
        assertThat(matrix.multiple(3), is(expect));
    }
}

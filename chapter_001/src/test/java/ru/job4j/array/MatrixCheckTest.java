package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MatrixCheck
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.7
 * @version 1.0
 * @since 10.10.2018
 */
public class MatrixCheckTest {

    @Test
    public void checkMatrixDiagonalEvenTrue() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, true},
                {true, true, true},
                {true, true, true}
        };
        assertThat(matrix.mono(input), is(true));
    }

    @Test
    public void checkMatrixDiagonalEvenFalse() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, true},
                {true, true, true},
                {true, true, false}
        };
        assertThat(matrix.mono(input), is(false));
    }

    @Test
    public void checkMatrixDiagonalOddFalse() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, false, true, false}
        };
        assertThat(matrix.mono(input), is(false));
    }

    @Test
    public void checkMatrixDiagonalOddTrue() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, false, true, true}
        };
        assertThat(matrix.mono(input), is(true));
    }

}

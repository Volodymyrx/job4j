package com;

import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertTest {
    @Test
    public void when7ElementsThen9() {
        Convert list = new Convert();
        int[][] result = list.makeArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2on2ArrayThenList4() {
        Convert list = new Convert();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.makeList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on4ArrayThenList12() {
        Convert list = new Convert();
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        );
        List<Integer> result = list.makeList(input);
        assertThat(result, is(expect));
    }
}
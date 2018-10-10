package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BubbleSort
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.5
 * @version 1.0
 * @since 10.10.2018
 */
public class BubbleSortTest {

    @Test
    public void checkSortArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] unsortedArray = new int[]{4, 6, 2, 8, 1, -5};
        int[] expect = new int[]{-5, 1, 2, 4, 6, 8};
        int[] result = bubbleSort.sort(unsortedArray);
        assertThat((result), is(expect));
    }
}

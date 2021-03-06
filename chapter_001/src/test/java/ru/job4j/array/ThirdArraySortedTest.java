package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ThirdArraySortedTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson question add
 * @version 1.2
 * @since 13.10.2018
 */
public class ThirdArraySortedTest {

    @Test
    public void checkIfSecondShorterThenFirst() {
        ThirdArraySorted thirdArraySorted = new ThirdArraySorted();
        int[] inputArray1 = new int[]{2, 5, 8, 9, 24, 378};
        int[] inputArray2 = new int[]{0, 7, 10, 22};
        int[] expetArray = new int[]{0, 2, 5, 7, 8, 9, 10, 22, 24, 378};
        int[] resutlArray = thirdArraySorted.makeThirdArraySorted(inputArray1, inputArray2);
        assertThat(resutlArray, is(expetArray));
    }

    @Test
    public void checkIfFirstShorterThenSecondThen() {
        ThirdArraySorted thirdArraySorted = new ThirdArraySorted();
        int[] inputArray1 = new int[]{0, 7, 10, 22};
        int[] inputArray2 = new int[]{2, 5, 8, 9, 24, 378};
        int[] expetArray = new int[]{0, 2, 5, 7, 8, 9, 10, 22, 24, 378};
        int[] resutlArray = thirdArraySorted.makeThirdArraySorted(inputArray1, inputArray2);
        assertThat(resutlArray, is(expetArray));
    }

    @Test
    public void checkIfFirstArrayLengthZiro() {
        ThirdArraySorted thirdArraySorted = new ThirdArraySorted();
        int[] inputArray1 = new int[]{};
        int[] inputArray2 = new int[]{0, 7, 10, 22};
        int[] expetArray = new int[]{0, 7, 10, 22};
        int[] resutlArray = thirdArraySorted.makeThirdArraySorted(inputArray1, inputArray2);
        assertThat(resutlArray, is(expetArray));
    }

    @Test
    public void checkIfSecondArrayLengthZiro() {
        ThirdArraySorted thirdArraySorted = new ThirdArraySorted();
        int[] inputArray1 = new int[]{0, 7, 10, 22};
        int[] inputArray2 = new int[]{};
        int[] expetArray = new int[]{0, 7, 10, 22};
        int[] resutlArray = thirdArraySorted.makeThirdArraySorted(inputArray1, inputArray2);
        assertThat(resutlArray, is(expetArray));
    }

    @Test
    public void checkIfBothAreLengthZiro() {
        ThirdArraySorted thirdArraySorted = new ThirdArraySorted();
        int[] inputArray1 = new int[]{};
        int[] inputArray2 = new int[]{};
        int[] expetArray = new int[]{};
        int[] resutlArray = thirdArraySorted.makeThirdArraySorted(inputArray1, inputArray2);
        assertThat(resutlArray, is(expetArray));
    }
}

package ru.job4j.array;

import java.util.Arrays;

/**
 * ThirdArraySorted
 * with two sorted array make third sorted array
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson question add
 * @version 1.2
 * @since 13.10.2018
 */
public class ThirdArraySorted {
    /**
     * method with two sorted array make third sorted array
     * version 2
     *
     * @param firstArray and secondArray are sorted int array
     * @return sorted array
     */
    public int[] makeThirdArraySorted(int[] firstArray, int[] secondArray) {
        int[] thirdArray = new int[firstArray.length + secondArray.length];
        if (firstArray.length == 0) {
            return Arrays.copyOf(secondArray, secondArray.length);
        }
        if (secondArray.length == 0) {
            return Arrays.copyOf(firstArray, firstArray.length);
        }
        int countFirst = 0;
        int countSecond = 0;
        int countThird = 0;

        while (countThird < thirdArray.length) {
            thirdArray[countThird] = firstArray[countFirst] <= secondArray[countSecond] ? firstArray[countFirst++] : secondArray[countSecond++];
            if (countFirst == firstArray.length) {
                System.arraycopy(secondArray, countSecond, thirdArray, ++countThird, secondArray.length - countSecond);
                break;
            }
            if (countSecond == secondArray.length) {
                System.arraycopy(firstArray, countFirst, thirdArray, ++countThird, firstArray.length - countFirst);
                break;
            }
            countThird++;
        }
        return thirdArray;

    }
}

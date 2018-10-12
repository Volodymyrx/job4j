package ru.job4j.array;

/**
 * ThirdArraySorted
 * with two sorted array make third sorted array
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson question add
 * @version 1.0
 * @since 10.10.2018
 */
public class ThirdArraySorted {
    /**
     * method with two sorted array make third sorted array
     * version 1
     *
     * @param firstArray and secondArray are sorted int array
     * @return sorted array
     */
    public int[] makeThirdArraySorted(int[] firstArray, int[] secondArray) {
        int[] thirdArray = new int[(firstArray.length + secondArray.length)];
        int counterFirstArray = 0;
        int currentNumber1;
        int counterSecondArray = 0;
        int currentNumber2;
        for (int counterThirdArray = 0; counterThirdArray < thirdArray.length; counterThirdArray++) {

            if (counterFirstArray >= (firstArray.length)) {
                currentNumber1 = Integer.MAX_VALUE;
            } else {
                currentNumber1 = firstArray[counterFirstArray];
            }

            if (counterSecondArray >= (secondArray.length)) {
                currentNumber2 = Integer.MAX_VALUE;
            } else {
                currentNumber2 = secondArray[counterSecondArray];
            }

            if (currentNumber1 <= currentNumber2) {
                thirdArray[counterThirdArray] = currentNumber1;
                counterFirstArray++;
            } else {
                thirdArray[counterThirdArray] = currentNumber2;
                counterSecondArray++;
            }
        }
        return thirdArray;
    }
}

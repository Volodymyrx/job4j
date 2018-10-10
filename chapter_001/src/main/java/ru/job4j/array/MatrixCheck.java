package ru.job4j.array;

/**
 * MatrixCheck
 * check matrix
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.7
 * @version 1.0
 * @since 10.10.2018
 */
public class MatrixCheck {
    /**
     * method sort - sorting array int
     *
     * @param data is boolean array-matrix
     * @return true if diagonal is true or false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean slash = data[0][0];
        boolean backslash = data[0][data.length - 1];
        for (int i = 0; i < data.length; i++) {
            if ((data[i][i] != slash) || (data[i][data.length - 1 - i] != backslash)) {
                result = false;
                break;
            }
//            System.out.println("i"+i);
        }
        return result;
    }
}




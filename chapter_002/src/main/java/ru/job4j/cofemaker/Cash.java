package ru.job4j.cofemaker;

/**
 * class Cash
 * project CofeMaker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j task part2 plus
 * @version 1.0
 * @since 18.11.2018
 */
public class Cash {
    /**
     * calculate how mach minimum conts to changes 1,2,5,10
     *
     * @param value 100 or 50
     * @param price any int less then value, else return ziro
     * @return int of conits {10,10,5,}
     */
    public int[] changes(int value, int price) {
        int change = (value > price) ? value - price : 0;
        int coint10 = change / 10;
        int coint5 = (change % 10) / 5;
        int coint2 = (change % 10 % 5) / 2;
        int coint1 = change % 10 % 5 % 2;
        int[] coints = new int[(coint10 + coint5 + coint2 + coint1)];
        for (int i = 0; i < coints.length; i++) {
            if (i < coint10) {
                coints[i] = 10;
            } else if (i < (coint10 + coint5)) {
                coints[i] = 5;
            } else if (i < (coint10 + coint5 + coint2)) {
                coints[i] = 2;
            } else {
                coints[i] = 1;
            }
        }
        return coints;
    }
}
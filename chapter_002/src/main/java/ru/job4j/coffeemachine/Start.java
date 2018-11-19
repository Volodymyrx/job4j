package ru.job4j.coffeemachine;

/**
 * class Start
 * project Coffee Machine
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j task part2 plus
 * @version 1.2
 * @since 18.11.2018
 */
public class Start {
    public static void main(String[] args) {
        Start start = new Start();
        start.coffemachine();
    }

    /**
     * simple method without input and output for testing the work method cash.changes
     */
    public void coffemachine() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 7, 3, 8};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        this.arrayToSting(cash.changes(100, 8));

    }

    /**
     * print to screen
     *
     * @param arrays int array
     */
    private void arrayToSting(int[] arrays) {
        for (int item : arrays) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

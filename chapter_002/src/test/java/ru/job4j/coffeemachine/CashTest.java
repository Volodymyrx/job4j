package ru.job4j.coffeemachine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class Cash
 * project Coffe Machine
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j task part2 plus
 * @version 1.2
 * @since 18.11.2018
 */
public class CashTest {

    /**
     * public int[] changes(int value, int price)
     */
    @Test
    public void when50cofe35Then10and5() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 10, 3, 5};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        int[] coints = cash.changes(50, 35);
        assertThat(resutlString(coints), is("coints: 10, 5"));
    }

    @Test
    public void when100cofe35Then101010101010and5() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 10, 3, 5};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        int[] coints = cash.changes(100, 35);
        assertThat(resutlString(coints), is("coints: 10, 10, 10, 10, 10, 5, 5, 5"));
    }

    @Test
    public void when50cofe32Then10and5and2and1() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 10, 2, 5};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        int[] coints = cash.changes(50, 32);
        assertThat(resutlString(coints), is("coints: 10, 5, 2, 1"));
    }

    @Test
    public void when50cofe42Then5and2and1() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 10, 2, 5};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        int[] coints = cash.changes(50, 42);
        assertThat(resutlString(coints), is("coints: 5, 2, 1"));
    }

    @Test
    public void when50cofe47Then2and1() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 10, 2, 5};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        int[] coints = cash.changes(50, 47);
        assertThat(resutlString(coints), is("coints: 2, 1"));
    }

    @Test
    public void when50cofe48Then2() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 10, 3, 5};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        int[] coints = cash.changes(50, 48);
        assertThat(resutlString(coints), is("coints: 1, 1"));
    }

    @Test
    public void when50cofe49Then1() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 7, 3, 5};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        int[] coints = cash.changes(50, 49);
        assertThat(resutlString(coints), is("coints: 1"));
    }

    @Test
    public void when50cofe50Then0() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 10, 2, 5};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        int[] coints = cash.changes(50, 50);
        assertThat(resutlString(coints), is("coints"));
    }

    @Test
    public void when50cofe55Then0() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 10, 2, 5};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        int[] coints = cash.changes(50, 55);
        assertThat(resutlString(coints), is("coints"));
    }

    @Test
    public void when100cofe1Then0() {
        Cash cash = new Cash();
        int[] units = new int[]{1, 7, 2, 3};
        int quantites = 5;
        cash.uploadCashCoins(units, quantites);
        int[] coints = cash.changes(100, 1);
        assertThat(resutlString(coints), is("coints: 7, 7, 7, 7, 7, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1"));
    }

    /**
     * help print int array int to String
     *
     * @param coints any int[]
     * @return string
     */
    private String resutlString(int[] coints) {
        StringBuilder result = new StringBuilder("coints:");
        String resString;
        for (int coint : coints) {
            result.append(" ").append(coint).append(",");
        }
        result.deleteCharAt(result.length() - 1);
        resString = result.toString();
        return resString;

    }
}
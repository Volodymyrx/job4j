package ru.job4j.calculator;

/**
 * Calculate
 * make propetis of calculater
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 3.1
 * @version 1.0
 * @since 07.10.2018
 */
public class Calculator {

    //	for save result of all metods in this class
    private double result;

    /*
     * Method getter for field result
     * @return result from field of class
     * */
    public double getResult() {
        return result;
    }

    /**
     * Method add summ 2 number;
     *
     * @param first any double and second any double number
     *              return result in class fiels result
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract  2 number;
     * one minus two
     *
     * @param first any double and second any double number
     *              return result in class fiels result
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div 2 number;
     * one / two
     *
     * @param first any double and second any double number
     *              return result in class fiels result
     *              if two number is ziro return ziro
     */
    public void div(double first, double second) {
        if (second != 0) {
            this.result = first / second;
        } else {
            this.result = 0;
        }


    }

    /**
     * Method multiple 2 number;
     *
     * @param first any double and second any double number
     *              return result in class fiels result
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
}

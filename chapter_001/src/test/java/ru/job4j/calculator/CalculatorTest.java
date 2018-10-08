package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class Calculator.
 * *@author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 3.1
 *
 * @version 1.0
 * @since 07.10.2018
 */
public class CalculatorTest {

    /*
     * Test for method add(double,double)
     * */
    @Test
    public void whenAddonePlusOneThenTwo() {
        Calculator calculator = new Calculator();
        calculator.add(1D, 1D);
        double result = calculator.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /*
     * Test for method substract(double,double)
     * */
    @Test
    public void whenSixSubstractOneThenFive() {
        Calculator calculator = new Calculator();
        calculator.subtract(6D, 1D);
        double result = calculator.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }

    /*
     * Test for method div-div on ziro
     * */
    @Test
    public void whenSixDivZiroThenZiro() {
        Calculator calculator = new Calculator();
        calculator.div(6D, 0D);
        double result = calculator.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }

    /*
     * Test for method div-float point
     * */
    @Test
    public void whenFiveDivTwoThenTwoPontFive() {
        Calculator calculator = new Calculator();
        calculator.div(5.0, 2.0);
        double result = calculator.getResult();
        double expected = 2.5;
        assertThat(result, is(expected));
    }

    /*
     * Test for method div(double,double)
     * */
    @Test
    public void whenSixDivThreeThenTwo() {
        Calculator calculator = new Calculator();
        calculator.div(6D, 3D);
        double result = calculator.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }


    /*
     * Test for method multiple(double,double)
     * */
    @Test
    public void whenFiveMultipleThreeThenFifteen() {
        Calculator calculator = new Calculator();
        calculator.multiple(5D, 3D);
        double result = calculator.getResult();
        double expected = 15D;
        assertThat(result, is(expected));
    }


}
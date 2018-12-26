package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * class CalculateFunctionTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lessons 4.1
 * @version 1.0
 * @since 25.12.2018
 */
public class CalculateFunctionTest {

    @Test
    public void whenLineFunctionUntil3() {
        CalculateFunction calcFunc = new CalculateFunction();
        List<Double> list = calcFunc.diapason(1, 4, ((number) -> number * 5));
        assertThat(list, is(Arrays.asList(5.0, 10.0, 15.0)));
    }

    @Test
    public void whenSqureFunctionUntil3() {
        CalculateFunction calcFunc = new CalculateFunction();
        List<Double> list = calcFunc.diapason(1, 4, ((number) -> number * number));
        assertThat(list, is(Arrays.asList(1.0, 4.0, 9.0)));
    }

    @Test
    public void whenExpFunctionUntil3() {
        CalculateFunction calcFunc = new CalculateFunction();
        List<Double> list = calcFunc.diapason(1, 4, Math::exp);
        assertThat(list, is(Arrays.asList(2.718281828459045, 7.38905609893065, 20.085536923187668)));
    }


}
package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * class CalculateFunction
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lessons 4.1
 * @version 1.0
 * @since 25.12.2018
 */

public class CalculateFunction {

    /**
     * method calculate any function
     *
     * @param start int number for start calculate
     * @param end   int number for end calculate
     * @param func  Double Function Double
     * @return list of double result
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (double number = start; number < end; number++) {
            list.add(func.apply(number));
        }
        return list;
    }


    public static void main(String[] args) {
        CalculateFunction calcFunc = new CalculateFunction();
        int start = 0;
        int end = 10;
        int numLine = 5;

        List<Double> listLine = calcFunc.diapason(start, end, ((number) -> number * numLine));
        List<Double> listD = calcFunc.diapason(start, end, (number) -> number * number);
        List<Double> listExp = calcFunc.diapason(start, end, Math::exp);

        listLine.forEach(System.out::println);
        listD.forEach(System.out::println);
        listExp.forEach(System.out::println);
    }
}

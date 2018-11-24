package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class ConvertListTest
 * project lesson 3.3.1
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 24.11.2018
 */
public class ConvertListTest {

    @Test
    public void whenThreeIntArrayThenListInteger() {
        ConvertList convertList = new ConvertList();
        List<int[]> listArr = new ArrayList<>();
        listArr.add(new int[]{1, 2});
        listArr.add(new int[]{3, 4, 5, 6});
        listArr.add(new int[]{17, 18, 19});
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 17, 18, 19);
        List<Integer> result = convertList.convert(listArr);
        assertThat(result, is(expect));
    }

    @Test
    public void whenThreeIntArrayAndOneIsZiroThenListInteger() {
        ConvertList convertList = new ConvertList();
        List<int[]> listArr = new ArrayList<>();
        listArr.add(new int[]{1, 2});
        listArr.add(new int[]{});
        listArr.add(new int[]{17, 18, 19});
        List<Integer> expect = Arrays.asList(1, 2, 17, 18, 19);
        List<Integer> result = convertList.convert(listArr);
        assertThat(result, is(expect));
    }

}
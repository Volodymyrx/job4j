package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;

/**
 * ArrayDuplicate
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.8
 * @version 1.0
 * @since 10.10.2018
 */
public class ArrayDuplicateTest {

    @Test
    public void removeDuplicateString() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[]{"Привет", "Мир", "Привет", "May", "May", "May", "May", "Супер", "Мир"};
        String[] expect = new String[]{"Привет", "Мир", "Супер", "May"};
        String[] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }


}

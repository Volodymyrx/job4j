package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TurnTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.2
 * @version 1.0
 * @since 10.10.2018
 */
public class TurnTest {

    @Test
    public void controlTurnedEvent() {
        Turn turnObj = new Turn();
        int[] array = new int[]{2, 3, 5, 6, 8, 99};
        int[] result = turnObj.turn(array);
        int[] expectArray = new int[]{99, 8, 6, 5, 3, 2};
        assertThat(result, is(expectArray));
    }

    @Test
    public void controlTurnedOdd() {
        Turn turnObj = new Turn();
        int[] array = new int[]{1, 2, 3, 5, 6, 8, 99};
        int[] result = turnObj.turn(array);
        int[] expectArray = new int[]{99, 8, 6, 5, 3, 2, 1};
        assertThat(result, is(expectArray));
    }


}

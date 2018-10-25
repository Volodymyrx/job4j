package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * ValidateInputTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 6.2
 * @version 1.0
 * @since 22.10.2018
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenNoIntInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"a", "1"})
        );
        input.ask("Enter", new int[]{0, 1, 2, 3});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter validate data again.%n")
                )
        );
    }

    @Test
    public void whenIntTooBigInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"5", "1"})
        );
        input.ask("Enter", new int[]{0, 1, 2, 3});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please select key from menu.%n")
                )
        );
    }

    @Test
    public void whenAllOk() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"2", "1"})
        );
        input.ask("Enter", new int[]{0, 1, 2, 3});
        assertThat(
                this.mem.toString(),
                is(
                        ""
                )
        );
    }
}
package ru.job4j.shape;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.lang.*;

/**
 * PaintTest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 4.4
 * @version 1.2
 * @since 20.10.2018
 */
public class PaintTest {

    /**
     * получаем ссылку на стандартный вывод в консоль.
     * Создаем буфур для хранения вывода.
     * Заменяем стандартный вывод на вывод в пямять для тестирования.
     * выполняем действия пишушиее в консоль.
     * возвращаем обратно стандартный вывод в консоль.
     */
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String ln = System.lineSeparator();


    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        StartPaint startPaint = new StartPaint();
        startPaint.consoleTriangle(new Paint());
        assertThat(new String(out.toByteArray()), is(
                "   t   " + ln
                        + "  ttt  " + ln
                        + " ttttt " + ln
                        + "ttttttt" + ln
                        + ln
                )
        );
    }

    @Test
    public void whenDrawSquare() {
        StartPaint startPaint = new StartPaint();
        startPaint.consoleSquere(new Paint());
        assertThat(new String(out.toByteArray()), is(
                "sssssss" + ln
                        + "sssssss" + ln
                        + "sssssss" + ln
                        + "sssssss" + ln
                        + ln
                )
        );
    }

}

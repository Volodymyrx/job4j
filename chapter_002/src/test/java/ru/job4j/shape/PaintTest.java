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
 * @version 1.0
 * @since 19.10.2018
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

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenDrawSquare() {
        StartPaint startPaint = new StartPaint();
        startPaint.go();
        assertThat(new String(out.toByteArray()), is(
                "   t   \r\n"
                        + "  ttt  \r\n"
                        + " ttttt \r\n"
                        + "ttttttt\r\n"
                        + "\r\n"
                        + "sssssss\r\n"
                        + "sssssss\r\n"
                        + "sssssss\r\n"
                        + "sssssss\r\n"
                        + "\r\n"
                )
        );
    }
}

package ru.job4j.calculate;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test for class Calculate
*added excemple fromv 'JUnit.docx'
**@author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
*project job4j lesson 1.4
*@since 06.10.2018 
*@version 1.4.2
*/
public class CalculateTest {
	/**
	* Test method main
	*/
	@Test
	public void whenAddOneToOneThenTwo() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(out.toString(),  is ("Hello World\r\n"));
	}
	
	/**
	* Test method echo.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Petr Arsentev";
		String expect = "Echo, echo, echo : Petr Arsentev"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
 
}
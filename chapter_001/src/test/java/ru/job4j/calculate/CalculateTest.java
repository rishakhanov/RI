package ru.job4j.calculate;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Rajes Ishakhanov (rishakhanov@rambler.ru)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
/**
* Test echo.
*/ @Test
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Rajes Ishakhanov";
    String expect = "Echo, echo, echo : Rajes Ishakhanov"; 
    Calculate1 calc = new Calculate1();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
 
}
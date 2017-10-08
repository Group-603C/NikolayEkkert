import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest
{
    @Test
    public void calculate() throws Exception
    {
        Calculator exemplar = new Calculator();
        double actual = exemplar.calculate("");
        double expected = 74.2d;

        assertEquals("One Test", expected, actual);
    }

}
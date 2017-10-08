import static org.junit.Assert.*;

public class CalculatorTest
{
    @org.junit.Test
    public void calculate() throws Exception
    {
        Calculator exemplar1 = new Calculator();
        double expect1 = 74.2;
        double actual1 = exemplar1.calculate("6.2+(7+10)*4");
        assertEquals("One test", expect1, actual1, 0.0001);

        
    }
}
import static org.junit.Assert.*;

public class CalculatorTest
{
    @org.junit.Test
    public void calculate() throws Exception
    {
        Calculator exemplar1 = new Calculator();
        double expect = 74.2;
        double actual = exemplar1.calculate("6.2+(7+10)*4");
        assertEquals("One test", expect, actual, 0.0001);

//        expect = 74.2;
//        actual = exemplar1.calculate("6.2+7+10*4");
//        assertEquals("Two test", expect, actual, 0.0001);
//
//        expect = 74.2;
//        actual = exemplar1.calculate("6.2+7+10*4");
//        assertEquals("Three test", expect, actual, 0.0001);
//
//        expect = 74.2;
//        actual = exemplar1.calculate("2+3-4*5");
//        assertEquals("Four test", expect, actual, 0.0001);
//
//        expect = 74.2;
//        actual = exemplar1.calculate("4*5-2+3");
//        assertEquals("Five test", expect, actual, 0.0001);
    }
}
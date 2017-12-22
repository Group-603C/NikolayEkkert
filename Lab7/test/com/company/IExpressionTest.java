package com.company;

import com.company.binary.*;
import com.company.tools.CacheValue;
import com.company.unary.Absolute;
import com.company.unary.Negative;
import com.company.unary.Square;
import com.company.unary.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IExpressionTest {

    private final double eps = 0.000000001;
    private IExpression expression;


    @BeforeEach
    void beforeEach() {
        expression = null;
    }

    @Test
    void addition() {

        expression = new Addition("123.123");
        assertEquals(123.123, expression.calculate(), eps);

        expression = new Addition("123.123", 1.4);
        assertEquals(124.523, expression.calculate(), eps);

        expression = new Addition("123.123", 1.2, "1.1", 42, "0");
        assertEquals(167.423, expression.calculate(), eps);
    }

    @Test
    void multiplication() {

        expression = new Multiplication("1.2");
        assertEquals(1.2, expression.calculate(), eps);

        expression = new Multiplication("1.2", 1.3);
        assertEquals(1.56, expression.calculate(), eps);

        expression = new Multiplication("1.2", 1.2, "1");
        assertEquals(1.44, expression.calculate(), eps);
    }

    @Test
    void division() {

        expression = new Division("37.2", 2.5);
        assertEquals(14.88, expression.calculate(), eps, "Division pair");

        expression = new Division("0", 1);
        assertEquals(0, expression.calculate(), eps, "Division zero left");

        expression = new Division("1.5", 0);
        assertEquals(Double.NaN, expression.calculate(), eps, "Division zero right");

        expression = new Division("-1.5", 2);
        assertEquals(-0.75, expression.calculate(), eps, "Division negative value");

        expression = new Division("2.5", -2);
        assertEquals(-1.25, expression.calculate(), eps, "Division negative value");

        expression = new Division("-10.5", -2.5);
        assertEquals(4.2, expression.calculate(), eps, "Division negative value");

    }

    @Test
    void rest() {

        expression = new Rest("15.5", 3);
        assertEquals(0.5, expression.calculate(), eps);

        expression = new Rest("43.5", 1.75);
        assertEquals(1.5, expression.calculate(), eps);

        expression = new Rest("43.5", 0);
        assertEquals(Double.NaN, expression.calculate(), eps);

        expression = new Rest("43.5", -2);
        assertEquals(1.5, expression.calculate(), eps);

        expression = new Rest("-20.5", 2.5);
        assertEquals(-0.5, expression.calculate(), eps);

        expression = new Rest("-17.5", -4.5);
        assertEquals(-4, expression.calculate(), eps);
    }

    @Test
    void power() {

        expression = new Power("4.1", 2);
        assertEquals(16.81, expression.calculate(), eps);

        expression = new Power(16.81, 1.0 / 2);
        assertEquals(4.1, expression.calculate(), eps);

        expression = new Power(-27, 1.0 / 3);
        assertEquals(-3, expression.calculate(), eps);

        expression = new Power(-8, 5.0 / 3);
        assertEquals(-32, expression.calculate(), eps);

        expression = new Power(-16.81, 1.0 / 2);
        assertTrue(Double.isNaN(expression.calculate()));
    }

    @Test
    void subtraction() {

        expression = new Subtraction("1.2", 10.1);
        assertEquals(-8.9, expression.calculate(), eps);
    }

    @Test
    void negative() {

        expression = new Negative("1.2");
        assertEquals(-1.2, expression.calculate(), eps);

        expression = new Negative(-10.1);
        assertEquals(10.1, expression.calculate(), eps);
    }

    @Test
    void absolute() {

        expression = new Absolute("-10.2");
        assertEquals(10.2, expression.calculate(), eps);

        expression = new Absolute(302.56);
        assertEquals(302.56, expression.calculate(), eps);
    }

    @Test
    void square() {

        expression = new Square("2.5");
        assertEquals(6.25, expression.calculate(), eps);

        expression = new Square("-2.5");
        assertEquals(6.25, expression.calculate(), eps);
    }

    @Test
    void value() {

        try {
            expression = new Value(null);
            fail("Process null reference");
        }
        catch (NullPointerException ignored) {
        }


        try {
            expression = new Value(new Object());
            fail("Process custom object");
        }
        catch (NumberFormatException ignored) {
        }

        try {
            expression = new Value(new Object());
            fail("Fall");
        }
        catch (NumberFormatException ignored) {
        }

        try {
            expression = new Value(false);
            fail("Fall");
        }
        catch (NumberFormatException ignored) {
        }

        try {
            expression = new Value('f');
            fail("Fall");
        }
        catch (NumberFormatException ignored) {
        }

        check(42, new Value(new TestExpression()));
        check(42, new Value("42"));
        check(42.2, new Value("42.2"));
        check(42, new Value((byte) 42));
        check(42, new Value((short) 42));
        check(42, new Value(42));
        check(42, new Value((long) 42));
        check(42.2, new Value((float) 42.2));
        check(42.2, new Value(42.2));
    }

    private void check(double value, IExpression expression) {
        assertEquals(value, expression.calculate(), eps);
    }

    @Test
    void cacheValue() {

        TestExpression tester = new TestExpression();

        expression = new CacheValue(tester);
        assertEquals(0, tester.callCounter);

        assertEquals(42, expression.calculate(), eps);
        assertEquals(42, expression.calculate(), eps);
        assertEquals(42, expression.calculate(), eps);
        assertEquals(1, tester.callCounter);

        expression = new CacheValue(tester);
        assertEquals(1, tester.callCounter);

        assertEquals(42, expression.calculate(), eps);
        assertEquals(42, expression.calculate(), eps);
        assertEquals(42, expression.calculate(), eps);
        assertEquals(1, tester.callCounter);
    }

    private class TestExpression implements IExpression {

        int callCounter;


        TestExpression() {
            callCounter = 0;
        }

        @Override
        public double calculate() {

            callCounter++;

            return 42;
        }
    }
}

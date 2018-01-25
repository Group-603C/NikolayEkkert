package com.company;

import java.math.BigDecimal;
import static java.math.BigDecimal.*;

class Pi {

    private static final BigDecimal TWO = new BigDecimal(2);
    private static final BigDecimal FOUR = new BigDecimal(4);


    private static BigDecimal calculate(final int limit) {

        BigDecimal a = ONE;
        BigDecimal b = ONE.divide(sqrt(TWO, limit), limit, ROUND_HALF_UP);
        BigDecimal t = new BigDecimal(0.25);
        BigDecimal x = ONE;
        BigDecimal y;

        while (!a.equals(b)) {

            y = a;
            a = a.add(b).divide(TWO, limit, ROUND_HALF_UP);
            b = sqrt(b.multiply(y), limit);
            t = t.subtract(x.multiply(y.subtract(a).multiply(y.subtract(a))));
            x = x.multiply(TWO);
        }

        return a.add(b).multiply(a.add(b)).divide(t.multiply(FOUR), limit, ROUND_HALF_UP);
    }

    private static BigDecimal sqrt(BigDecimal A, final int limit) {

        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));

        while (!x0.equals(x1)) {

            x0 = x1;
            x1 = A.divide(x0, limit, ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, limit, ROUND_HALF_UP);
        }

        return x1;
    }

    public static void main(String[] args) {

        double startTime = System.nanoTime();
        System.out.println(calculate(1000));
        double estimatedTime = System.nanoTime() - startTime;

        System.out.println(estimatedTime / 1000000000);
    }
}
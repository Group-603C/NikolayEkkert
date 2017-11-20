package com.company;

public class UnaryExpression {

    private double firstValue;


    UnaryExpression(double value) {

        this.firstValue = value;
    }

    public double negative() {

        return -firstValue;
    }

    public double plus() {

        return firstValue;
    }

    public int bitwiseComplementOf() {

        StringBuilder result = new StringBuilder();
        for (char element : Integer.toBinaryString((int) firstValue)
                                   .toCharArray()) {

            result.append(element == '0' ? "1" : "0");
        }

        return Integer.parseInt(result.toString(), 2);
    }

    public int increment() {

        return (int) firstValue + 1;
    }

    public long decrement() {

        return (int) firstValue - 1;
    }

}

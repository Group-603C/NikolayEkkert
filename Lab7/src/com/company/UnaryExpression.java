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

        return ~(int) firstValue;
    }

    public int increment() {

        return (int) firstValue + 1;
    }

    public long decrement() {

        return (int) firstValue - 1;
    }

}

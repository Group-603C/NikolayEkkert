package com.company;

public class BinaryExpression {

    private double firstValue;
    private double secondValue;
    private double oneElement;

    BinaryExpression(double first,
                     double second) {

        this.firstValue = first;
        this.secondValue = second;
    }

    public double addition() {

        return firstValue + secondValue;
    }

    public double substraction() {

        return firstValue - secondValue;
    }

    public double multiplication() {

        return firstValue * secondValue;
    }

    public double division() {

        return firstValue / secondValue;
    }

    public double rest() {
        
        return firstValue % secondValue;
    }

    public double power() {

        double result = firstValue;
        for (int i = 0; i < secondValue; i++) {
            result *= secondValue;
        }

        return result;
    }

    public double negative() {

        return 0 - oneElement;
    }

    public double absolute() {

        return oneElement < 0 ? -1 * oneElement : oneElement;
    }

    public double square() {

        return oneElement * oneElement;
    }
}

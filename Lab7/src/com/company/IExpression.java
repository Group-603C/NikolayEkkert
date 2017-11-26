package com.company;

public interface IExpression {

    double calculate();
}

class BinaryExpression implements IExpression{

    @Override
    public double calculate() {
        return 0;
    }

    public double addition() {
        return -1;
    }

    public double subtraction() {return -1;}

    public double multiplication() {return -1;}

    public double division() {return -1;}

    public double rest() {return -1;}

    public double power() {return -1;}

    public double negative() {return -1;}

    public double absolute() {return -1;}

    public double square() {return -1;}

    public double value() {return -1;}
}

class UnaryExpression implements  IExpression{

    @Override
    public double calculate() {
        return 0;
    }

    public double negative() {return -1;}

    public double absolute() {return -1;}

    public double square() {return -1;}

    public double value() {return -1;}
}

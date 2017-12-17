package com.company.unary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;

public class Absolute extends UnaryExpression implements IExpression {

    private CacheCalculation cacheValue;


    public Absolute(Object value) {

        super(value);

        cacheValue = new CacheCalculation(()->Math.abs(this.value.calculate()));
    }

    @Override
    public double calculate() {
        return cacheValue.calculate();
    }
}

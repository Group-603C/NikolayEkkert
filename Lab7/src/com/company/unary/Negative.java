package com.company.unary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;

public class Negative extends UnaryExpression implements IExpression {

    private CacheCalculation cacheValue;


    public Negative(Object value) {

        super(value);

        cacheValue = new CacheCalculation(()->-this.value.calculate());
    }

    @Override
    public double calculate() {
        return cacheValue.calculate();
    }
}

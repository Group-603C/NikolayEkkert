package com.company.unary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;

public class Square extends UnaryExpression implements IExpression {

    private CacheCalculation cacheValue;


    public Square(Object value) {

        super(value);

        cacheValue = new CacheCalculation(()->(this.value.calculate() * this.value.calculate()));
    }

    @Override
    public double calculate() {
        return cacheValue.calculate();
    }
}

package com.company.unary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;
import com.company.tools.CacheValue;

public class UnaryExpression implements IExpression {

    protected IExpression value;
    protected CacheCalculation cache;

    protected UnaryExpression(Object value) {

        this.value = new CacheValue(value);
        this.cache = null;
    }

    @Override
    public double calculate() {

        if (null == cache) {
            return Double.NaN;
        }

        return cache.calculate();
    }
}

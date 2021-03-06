package com.company.binary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;
import com.company.tools.CacheValue;

public class BinaryExpression implements IExpression {

    protected CacheCalculation cache;

    private IExpression left;
    private IExpression right;

    public BinaryExpression(Object left, Object right) {

        this.left = new CacheValue(left);
        this.right = new CacheValue(right);
        this.cache = null;
    }

    @Override
    public double calculate() {

        if (null == cache) {
            return Double.NaN;
        }

        return cache.calculate();
    }

    public IExpression getLeft() {
        return left;
    }

    public IExpression getRight() {
        return right;
    }

    public void setRight(IExpression expression) {
        this.right = new CacheValue(expression);
    }
}

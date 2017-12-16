package com.company.binary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;

public class Subtraction extends BinaryExpression implements IExpression {

    public Subtraction(Object left, Object right) {
        super(left, right);

        this.cache = new CacheCalculation(()->{
            return this.getLeft().calculate() - this.getRight().calculate();
        });
    }
}

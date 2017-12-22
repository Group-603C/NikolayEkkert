package com.company.binary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;

public class Division extends BinaryExpression implements IExpression {

    public Division(Object left, Object right) {

        super(left, right);

        this.cache = new CacheCalculation(() -> {

            if (this.getRight().calculate() != 0) {
                return this.getLeft().calculate() / this.getRight().calculate();
            }

            return Double.NaN;
        });
    }
}
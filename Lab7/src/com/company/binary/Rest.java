package com.company.binary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;

public class Rest extends BinaryExpression implements IExpression {

    public Rest(Object left, Object right) {

        super(left, right);

        this.cache = new CacheCalculation(()->{

            double divider = this.getLeft().calculate();
            double dividend = this.getRight().calculate();

            if (dividend == 0) {
                return Double.NaN;
            }

            return divider % dividend;
        });
    }
}

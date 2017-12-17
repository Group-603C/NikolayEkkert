package com.company.binary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;
import com.company.unary.Value;

public class Rest extends BinaryExpression implements IExpression {

    public Rest(Object left, Object... right) {

        super(left, new Value(1));

        if (1 == right.length) {
            this.setRight(new Rest(right[0], new Object[] {}));
        }
        else if (1 < right.length) {

            Rest root = new Rest(right[0], 1);
            this.setRight(root);

            for (int i = 1; i < right.length - 1; i++) {

                Rest next = new Rest(right[i], 1);
                root.setRight(next);
                root = next;
            }
        }

        this.cache = new CacheCalculation(()->this.getLeft().calculate() % this.getRight().calculate());
    }
}

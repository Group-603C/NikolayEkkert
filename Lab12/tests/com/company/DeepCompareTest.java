package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.Cyclic;
import tools.PrivateField;
import tools.PublicField;

class DeepCompareTest {

    private IDeepCompare comparator = new DeepCompare();


    @Test
    public void nullPointer() {

        PublicField<Integer> firstObject = null;
        PublicField<Integer> secondObject = null;
        PublicField<Integer> thirdObject = new PublicField<>(6);

        Assertions.assertTrue(comparator.isEqual(firstObject, secondObject));
        Assertions.assertFalse(comparator.isEqual(firstObject, thirdObject));
    }

    @Test
    public void privateFields() {

        PrivateField firstObject = new PrivateField(34, 'a');
        PrivateField secondObject = new PrivateField(34, 'a');
        PrivateField thirdObject = new PrivateField(15, 'a');

        Assertions.assertTrue(comparator.isEqual(firstObject, secondObject));
        Assertions.assertFalse(comparator.isEqual(firstObject, thirdObject));
    }

    @Test
    public void cyclicLinks() {

        Cyclic firstObject = new Cyclic();
        Cyclic secondObject = new Cyclic(firstObject);
        Cyclic thirdObject = new Cyclic(secondObject);
        firstObject = secondObject;

        Assertions.assertFalse(comparator.isEqual(firstObject, thirdObject));
    }

    @Test
    public void publicFields() {

        int i = 1;
        PublicField<String> firstObject = new PublicField<>("Test" + i);
        PublicField<String> secondObject = new PublicField<>("Test" + i);
        PublicField<String> thirdObject = new PublicField<>("1gdfs");

        Assertions.assertTrue(comparator.isEqual(firstObject, secondObject));
        Assertions.assertFalse(comparator.isEqual(firstObject, thirdObject));
    }

    @Test
    public void compareStrings() {

        String left = "";
        left += "Not";
        left += "game";
        StringBuilder right = new StringBuilder();
        right.append("No").append("t").append("ga").append("me");

        Assertions.assertTrue(comparator.isEqual(left, right.toString()));

        right.append("4");
        Assertions.assertFalse(comparator.isEqual(left, right.toString()));
    }

}
package com.company;


import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

public class DeepCompare implements IDeepCompare {

    private ArrayList verifyObjects = new ArrayList();


    @Override
    public boolean isEqual(Object left, Object right) {

        if (left == right) {
            return true;

        }
        if (null == left || null == right) {
            return false;

        }

        if (left.getClass() != right.getClass()) {
            return false;

        }
        if (analyzeObject(left) != -1 || analyzeObject(right) != -1) {
            return false;

        }

        if (left instanceof Boolean) {
            return (boolean) left == (boolean) right;

        }
        else if (left instanceof Character) {
            return (char) left == (char) right;

        }
        else if (left instanceof Byte) {
            return Objects.equals((Byte) left, (Byte) right);

        }
        else if (left instanceof Short) {
            return Objects.equals((Short) left, (Short) right);

        }
        else if (left instanceof Integer) {
            return (int) left == (int) right;

        }
        else if (left instanceof Long) {
            return (long) left == (long) right;

        }
        else if (left instanceof Float) {
            return (float) left == (float) right;

        }
        else if (left instanceof Double) {
            return (double) left == (double) right;

        }


        verifyObjects.add(left);
        verifyObjects.add(right);

        if (left.getClass().isArray()) {

            if (Array.getLength(left) != Array.getLength(right)) {
                remove(left, right);

                return false;
            }
            for (int i = 0; i < Array.getLength(left); i++) {

                if (!isEqual(Array.get(left, i), Array.get(right, i))) {
                    remove(left, right);

                    return false;
                }
            }
        }
        else {
            for (Field field : left.getClass().getDeclaredFields()) {

                try {
                    field.setAccessible(true);

                    if (!isEqual(field.get(left), field.get(right))) {
                        remove(left, right);

                        return false;
                    }
                }
                catch (IllegalAccessException e) {
                }
            }
        }
        remove(left, right);

        return true;
    }

    private int analyzeObject(Object element) {
        return verifyObjects.indexOf(element);
    }

    private void remove(Object left, Object right) {

        verifyObjects.remove(left);
        verifyObjects.remove(right);
    }
}

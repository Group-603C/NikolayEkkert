package com.company;

public class Calculator {

    static double calculate(String expression) {
        return -1d;
    }

    private static boolean isCorrect(String expression) {

        if (expression == null) {
            return false;
        }

        int counter = 0;
        for (char symbol : expression.toCharArray()) {

            if (symbol == '(') {
                counter++;
            }
            else if (symbol == ')') {

                if (counter < 1) {
                    return false;
                }
            }
            else if (symbol != ' ' && !isOperator(symbol) && !Character.isDigit(symbol)) {
                return false;
            }
        }

        return counter > 0 ? false : true;
    }

    private static boolean isOperator(char character) {

        return character == '+' || character == '-' || character == '/' || character == '*';
    }
}

package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main
{

    public static String InfixToPostfix(String expression)
    {
        Map<String, Integer> dictionaryPriority = new HashMap<String, Integer>();
        dictionaryPriority.put("(", 1);
        dictionaryPriority.put(")", 2);
        dictionaryPriority.put("+", 3);
        dictionaryPriority.put("-", 3);
        dictionaryPriority.put("*", 4);
        dictionaryPriority.put("/", 4);

        Stack<String> stack = new Stack<>();

        String tempExpression = "";

        for (int i = 0; i < expression.length(); i++)
        {
            String oneSymbol = expression.substring(i, i + 1);
            if (oneSymbol.getBytes()[0] >= 48 && oneSymbol.getBytes()[0] <= 57)
            {
                tempExpression += oneSymbol;
            }
            else if (stack.empty())
            {
                stack.push(oneSymbol);
            }
            else if (!(stack.empty()))
            {
                if (dictionaryPriority.get(stack.peek()) < dictionaryPriority.get(oneSymbol))
                {
                    stack.push(oneSymbol);
                }
                else
                {
                    while (!stack.empty() && dictionaryPriority.get(stack.peek()) >= dictionaryPriority.get(oneSymbol))
                    {
                        tempExpression += stack.pop();
                    }
                    stack.push(oneSymbol);
                }
            }
        }

        while (!stack.empty())
        {
            tempExpression += stack.pop();
        }

        return tempExpression;
    }

    public static int CalculatePostfix(String expression)
    {
        int resultCalculatePostfix = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++)
        {
            String oneSymbol = expression.substring(i, i + 1);

            if (oneSymbol.getBytes()[0] >= 48 && oneSymbol.getBytes()[0] <= 57)
            {
                stack.push((int) oneSymbol.charAt(0) - 48);
            }
            else if ((oneSymbol.equals(")")) || oneSymbol.equals("(") || oneSymbol.equals("+") || oneSymbol.equals("-") || oneSymbol.equals("*") || oneSymbol.equals("/"))
            {
                switch (oneSymbol)
                {
                    case "+":
                        resultCalculatePostfix = stack.pop() + stack.pop();
                        stack.push(resultCalculatePostfix);
                        break;
                    case "-":
                        ;
                        resultCalculatePostfix = stack.pop() - stack.pop();
                        stack.push(resultCalculatePostfix);
                        break;
                    case "*":
                        resultCalculatePostfix = stack.pop() * stack.pop();
                        stack.push(resultCalculatePostfix);
                        break;
                    case "/":
                        resultCalculatePostfix = stack.pop() / stack.pop();
                        stack.push(resultCalculatePostfix);
                        break;
                }
            }
        }
        return resultCalculatePostfix;
    }

    public static void main(String[] args)
    {
        System.out.println(CalculatePostfix(InfixToPostfix("6+7+1*4")));
    }
}

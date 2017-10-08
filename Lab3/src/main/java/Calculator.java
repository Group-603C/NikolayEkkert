import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator
{
    private static Map<String, Double> dictionaryPriority = priorities();

    private static Map priorities()
    {
        dictionaryPriority = new HashMap<String, Double>();
        dictionaryPriority.put("(", 0d);
        dictionaryPriority.put("+", 1d);
        dictionaryPriority.put("-", 1d);
        dictionaryPriority.put("*", 2d);
        dictionaryPriority.put("/", 2d);

        return dictionaryPriority;
    }

    private static ArrayList<String> divisionArray(String expresion)
    {
        String tempExpresion = "";
        ArrayList<String> arrayElementExpresion = new ArrayList<String>();

        char[] elementsExpresion = expresion.replaceAll(" ", "").replaceAll(",", ".").toCharArray();

        for (int i = 0; i < elementsExpresion.length; i++)
        {
            if (elementsExpresion[i] != '+' && elementsExpresion[i] != '-' && elementsExpresion[i] != '/' && elementsExpresion[i] != '*' && elementsExpresion[i] != '(' && elementsExpresion[i] != ')')
            {
                tempExpresion += elementsExpresion[i];
                continue;
            }
            if (elementsExpresion[i] == '.')
            {
                tempExpresion += elementsExpresion[i];
                continue;
            }

            arrayElementExpresion.add(tempExpresion);
            tempExpresion = "" + elementsExpresion[i];

            arrayElementExpresion.add(tempExpresion);
            tempExpresion = "";
        }
        arrayElementExpresion.add(tempExpresion);


        while (arrayElementExpresion.contains(""))
        {
            arrayElementExpresion.remove("");
        }

        return arrayElementExpresion;
    }

    private static ArrayList<String> infixToPostfix(String expresion)
    {
        ArrayList<String> arrayElementExpresion = divisionArray(expresion);

        ArrayList<String> elementsExpresion = new ArrayList<String>();  //здесь элементы постфиксной записи
        Stack<String> stackSymbol = new Stack<String>();  //здесь операции для стека

        for (String element : arrayElementExpresion)
        {
            try
            {
                double checkNumber = Double.parseDouble(element);
                elementsExpresion.add(element);
            }
            catch (NumberFormatException e)
            {
                if (stackSymbol.size() == 0)
                {
                    stackSymbol.push(element);
                }
                else if (stackSymbol.peek().equals("("))
                {
                    stackSymbol.push(element);
                }


                else if (element.equals(")"))
                {
                    String skobka = "(";
                    for (; ; )
                    {
                        if (stackSymbol.peek().equals(skobka))
                        {
                            stackSymbol.pop();
                            break;
                        }
                        else
                        {
                            elementsExpresion.add(stackSymbol.pop());
                        }
                    }
                }
                else if (dictionaryPriority.get(element) > dictionaryPriority.get(stackSymbol.peek()))
                {
                    stackSymbol.push(element);
                }
                else if (dictionaryPriority.get(element) <= dictionaryPriority.get(stackSymbol.peek()))
                {
                    while (stackSymbol.peek().equals("(") || dictionaryPriority.get(stackSymbol.peek()) < dictionaryPriority.get(element))
                    {
                        elementsExpresion.add(stackSymbol.pop());
                    }
                    stackSymbol.push(element);
                }
                System.out.println(stackSymbol);
            }
        }
        System.out.println("AAA: "+ elementsExpresion);
        while (stackSymbol.size() != 0)
        {
            elementsExpresion.add(stackSymbol.pop());
        }

//        System.out.println(elementsExpresion);
        return elementsExpresion;
    }

    public double calculate(String expresion)
    {
        ArrayList<String> elementsExpresion = infixToPostfix(expresion);
        double resultCalcPostfix = 0d;
        Stack<Double> stackCalculate = new Stack<Double>();

        for (int i = 0; i < elementsExpresion.size(); i++)
        {
            try
            {
                double temp = Double.parseDouble(elementsExpresion.get(i));
                stackCalculate.push(temp);
            }
            catch (NumberFormatException e)
            {
                if (elementsExpresion.get(i).contains("+"))
                {
                    resultCalcPostfix = stackCalculate.pop() + stackCalculate.pop();
                    stackCalculate.push(resultCalcPostfix);
                }
                else if (elementsExpresion.get(i).contains("-"))
                {
                    resultCalcPostfix = stackCalculate.pop() - stackCalculate.pop();
                    stackCalculate.push(resultCalcPostfix);
                }
                else if (elementsExpresion.get(i).contains("*"))
                {
                    resultCalcPostfix = stackCalculate.pop() * stackCalculate.pop();
                    stackCalculate.push(resultCalcPostfix);
                }
                else if (elementsExpresion.get(i).contains("/"))
                {
                    resultCalcPostfix = stackCalculate.pop() / stackCalculate.pop();
                    stackCalculate.push(resultCalcPostfix);
                }
            }
        }

        return resultCalcPostfix;
    }
}

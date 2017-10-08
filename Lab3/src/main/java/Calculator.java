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
        dictionaryPriority.put("(", 1d);
        dictionaryPriority.put(")", 2d);
        dictionaryPriority.put("+", 3d);
        dictionaryPriority.put("-", 3d);
        dictionaryPriority.put("*", 4d);
        dictionaryPriority.put("/", 4d);

        return dictionaryPriority;
    }

    private static ArrayList<String> divisionArray(String expresion)
    {
        String tempExpresion = "";
        ArrayList<String> arrayElementExpresion = new ArrayList<String>();

        char[] elementsExpresion = expresion.replaceAll(" ", "").toCharArray();

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
                if (element.contains("+") || element.contains("-") || element.contains("/") || element.contains("*") || element.contains("(") || element.contains(")"))
                {
                    if (stackSymbol.size() == 0)
                    {
                        stackSymbol.push(element);
                    }
                    else if (dictionaryPriority.get(stackSymbol.peek()) < dictionaryPriority.get(element))
                    {
                        stackSymbol.push(element);
                    }
                    else
                    {
                        while (stackSymbol.size() != 0 && (dictionaryPriority.get(stackSymbol.peek()) >= dictionaryPriority.get(element)))
                        {
                            if (stackSymbol.peek().charAt(0) != '(' && stackSymbol.peek().charAt(0) != ')')
                            {
                                elementsExpresion.add(stackSymbol.pop());
                            }
                            else
                            {
                                stackSymbol.pop();
                            }
                        }
                        stackSymbol.push(element);
                    }
                }
            }
        }
        while (stackSymbol.size() != 0)
        {
            if (stackSymbol.peek().contains("(") && stackSymbol.peek().contains(")"))
            {
                stackSymbol.pop();
            }
            else
            {
                elementsExpresion.add(stackSymbol.pop());
            }
        }

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

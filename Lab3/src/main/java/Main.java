import java.util.*;

public class Main
{
    private static Map<String, Double> dictionaryPriority = Priorities();

    private static Map Priorities()
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

    public static double Calculate(String expresion)
    {
        String tempExpresion = "";
        ArrayList<String> arrayElementExpresion = new ArrayList<String>();

        char[] str = expresion.toCharArray();

        for (int i = 0; i < str.length; i++)
        {
            if (str[i] != '+' && str[i] != '-' && str[i] != '/' && str[i] != '*' && str[i] != '(' && str[i] != ')')
            {
                tempExpresion += str[i];
                continue;
            }
            if (str[i] == '.')
            {
                tempExpresion += str[i];
                continue;
            }
            arrayElementExpresion.add(tempExpresion);
            tempExpresion = "" + str[i];
            arrayElementExpresion.add(tempExpresion);
            tempExpresion = "";
        }
        arrayElementExpresion.add(tempExpresion);

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


    public static void main(String[] args)
    {
        String expresion = "6+7+10*4";

        System.out.println(Calculate(expresion));
    }
}

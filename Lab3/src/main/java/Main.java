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


    public static double Calculat(String expresion)
    {
//        Map<String, Double> dictionaryPriority = new HashMap<String, Double>();
//        dictionaryPriority.put("(", 1d);
//        dictionaryPriority.put(")", 2d);
//        dictionaryPriority.put("+", 3d);
//        dictionaryPriority.put("-", 3d);
//        dictionaryPriority.put("*", 4d);
//        dictionaryPriority.put("/", 4d);

//        Stack<String> stackSymbol = new Stack<String>();
//
//        String tempExpresion = "";
//
//        for (int i = 0; i < expresion.length(); i++)
//        {
//            String oneSymbol = expresion.substring(i, i + 1);
//            if (oneSymbol.getBytes()[0] >= 48 && oneSymbol.getBytes()[0] <= 57)
//            {
//                tempExpresion += oneSymbol;
//            }
//            else if (stackSymbol.empty())
//            {
//                stackSymbol.push(oneSymbol);
//            }
//            else if (!(stackSymbol.empty()))
//            {
//                if (dictionaryPriority.get(stackSymbol.peek()) < dictionaryPriority.get(oneSymbol))
//                {
//                    stackSymbol.push(oneSymbol);
//                }
//                else
//                {
//                    while (!stackSymbol.empty() && dictionaryPriority.get(stackSymbol.peek()) >= dictionaryPriority.get(oneSymbol))
//                    {
//                        tempExpresion += stackSymbol.pop();
//                    }
//                    stackSymbol.push(oneSymbol);
//                }
//            }
//        }

//        while (!stackSymbol.empty())
//        {
//            tempExpresion += stackSymbol.pop();
//        }
//
//        System.out.println(tempExpresion);


        int resultCalculatePostfix = 0;
//        Stack<Integer> stackCalc = new Stack<Integer>();
//
//        for (int i = 0; i < tempExpresion.length(); i++)
//        {
//            char oneSymbol = tempExpresion.substring(i, i + 1).charAt(0);
//
//            if ((int) oneSymbol >= 48 && (int) oneSymbol <= 57)
//            {
//                stackCalc.push((int) oneSymbol - 48);
//            }
//            else if ((oneSymbol == ')') || (oneSymbol == '(') || (oneSymbol == '+') || (oneSymbol == '-') || (oneSymbol == '*') || (oneSymbol == '/'))
//            {
//                switch (oneSymbol)
//                {
//                    case '+':
//                        resultCalculatePostfix = stackCalc.pop() + stackCalc.pop();
//                        stackCalc.push(resultCalculatePostfix);
//                        break;
//                    case '-':
//                        resultCalculatePostfix = stackCalc.pop() - stackCalc.pop();
//                        stackCalc.push(resultCalculatePostfix);
//                        break;
//                    case '*':
//                        resultCalculatePostfix = stackCalc.pop() * stackCalc.pop();
//                        stackCalc.push(resultCalculatePostfix);
//                        break;
//                    case '/':
//                        resultCalculatePostfix = stackCalc.pop() / stackCalc.pop();
//                        stackCalc.push(resultCalculatePostfix);
//                        break;
//                }
//            }
//        }

        return resultCalculatePostfix;
    }
//
//    public static boolean stackEmpty(Stack stack)
//    {
//
//    }

    {

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
        // System.out.println(arrayElementExpresion);

//System.out.println(arrayElementExpresion);

        ArrayList<String> elementsExpresion = new ArrayList<String>();  //здесь элементы постфиксной записи
        Stack<String> stackSymbol = new Stack<String>();  //здесь операции для стека

        for (String element : arrayElementExpresion)
        {
//            System.out.println("qqq - " + element);
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
                        //System.out.println("Стек пуст, помещаем в него: " + element);
                        stackSymbol.push(element);
                    }
                    else if (dictionaryPriority.get(stackSymbol.peek()) < dictionaryPriority.get(element))
                    {
                        //  System.out.println("Приоритет меньше, помещаем в стек элемент: " + element);
                        stackSymbol.push(element);
                    }
                    else
                    {
//                        System.out.println("Мы здесь");
                        while (stackSymbol.size() != 0 && (dictionaryPriority.get(stackSymbol.peek()) >= dictionaryPriority.get(element)))
                        {
                            if (stackSymbol.peek().charAt(0) != '(' && stackSymbol.peek().charAt(0) != ')')
                            {
                                //  System.out.println("Мы в счётчике");
                                elementsExpresion.add(stackSymbol.pop());
                            }
                            else
                            {
//                                System.out.println("peek = " + stackSymbol.peek());
                                stackSymbol.pop();
                            }
                        }
//                        System.out.println("Помещаем");
                        stackSymbol.push(element);
                    }
                }
            }
        }
        while (stackSymbol.size() != 0)
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
//        System.out.println(stackSymbol);
//        System.out.println(elementsExpresion);
//        System.out.println(tempExpresion);


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
                System.out.println(elementsExpresion.get(i).contains("+"));
                System.out.println(elementsExpresion.get(i));
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
                    resultCalcPostfix = stackCalculate.pop() - stackCalculate.pop();
                    stackCalculate.push(resultCalcPostfix);
                }
                else if (elementsExpresion.get(i).contains("/"))
                {
                    resultCalcPostfix = stackCalculate.pop() - stackCalculate.pop();
                    stackCalculate.push(resultCalcPostfix);
                }

//                switch (arrayElementExpresion.get(i).contains('+'))
//                {
//                    case '+':
//
//                        break;
//                    case '-':
//
//                        break;
//                    case '*':
//                        resultCalcPostfix = stackCalculate.pop() * stackCalculate.pop();
//                        stackCalculate.push(resultCalcPostfix);
//                        break;
//                    case '/':
//                        resultCalcPostfix = stackCalculate.pop() / stackCalculate.pop();
//                        stackCalculate.push(resultCalcPostfix);
//                        break;
//                }
            }
        }

        return resultCalcPostfix;
    }


    public static void main(String[] args)
    {
        String expresion = "124 + 90";

        System.out.println(Calculate(expresion));

//        String temp = " 100";
//        try
//        {
//            System.out.println("YES\t" + Double.parseDouble(temp));
//        }
//        catch (NumberFormatException e)
//        {
//            System.out.println("NO\t" + temp);
//    }


//        Stack<String> stackSymbol = new Stack<String>();
//        System.out.println(stackSymbol.size());
//        stackSymbol.push("1");
//        stackSymbol.push("2");
//        System.out.println(stackSymbol.size());
//        stackSymbol.pop();
//        System.out.println(stackSymbol.size());
//        stackSymbol.pop();
//        System.out.println(stackSymbol.size());
    }
}

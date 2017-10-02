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
            try
            {
                double checkNumber = Double.parseDouble(element);
                elementsExpresion.add(element);
            }
            catch (NumberFormatException e)
            {
                if (element.contains("+") || element.contains("-") || element.contains("/") || element.contains("*") || element.contains("(") || element.contains(")"))
                {
                    stackSymbol.push(element);

                    if (dictionaryPriority.get(stackSymbol.peek()) < dictionaryPriority.get(element))
                    {
                        stackSymbol.push(element);
                    }
                    else
                    {
//                        System.out.println("dsds - " + dictionaryPriority.get(stackSymbol.peek()));
//                        System.out.println("\t - " + dictionaryPriority.get(element));
//                        while (dictionaryPriority.get(stackSymbol.peek()) >= dictionaryPriority.get(element))
//                        {
//                            elementsExpresion.add(stackSymbol.pop());
//                        }
////                        stackSymbol.push(element);
                    }
                }
            }
        }
        System.out.println(stackSymbol);
        System.out.println(elementsExpresion);
        System.out.println(tempExpresion);
        return 0;
    }


    public static void main(String[] args)
    {
//        String expresion = "100+1.2345*2-(10/6)";
        String expresion = "6 + 5 * 4";

        Calculate(expresion);

//
//        Stack<String> stackSymbol = new Stack<String>();
//        stackSymbol.push("1");
//        stackSymbol.push("2");
//        stackSymbol.push("3");
//        stackSymbol.push("4");
//        stackSymbol.push("5");
//        stackSymbol.push("6");

//        System.out.println(stackSymbol.peek());
//        System.out.println(stackSymbol.peek());
//        System.out.println(stackSymbol.peek());
//        System.out.println(stackSymbol.peek());
//        System.out.println(stackSymbol.peek());
//        System.out.println(stackSymbol.peek());
//        System.out.println(stackSymbol.peek());
//        System.out.println(stackSymbol.peek());
//        System.out.println(stackSymbol.peek());
//        System.out.println(stackSymbol.peek());


    }
}

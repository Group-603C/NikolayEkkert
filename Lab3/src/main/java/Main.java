import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main
{
    public static double Calculate(String expresion)
    {
        Map<String, Integer> dictionaryPriority = new HashMap<String, Integer>();
        dictionaryPriority.put("(", 1);
        dictionaryPriority.put(")", 2);
        dictionaryPriority.put("+", 3);
        dictionaryPriority.put("-", 3);
        dictionaryPriority.put("*", 4);
        dictionaryPriority.put("/", 4);

        Stack<String> stackSymbol = new Stack<String>();

        String tempExpresion = "";

        for (int i = 0; i < expresion.length(); i++)
        {
            String oneSymbol = expresion.substring(i, i + 1);
            if (oneSymbol.getBytes()[0] >= 48 && oneSymbol.getBytes()[0] <= 57)
            {
                tempExpresion += oneSymbol;
            }
            else if (stackSymbol.empty())
            {
                stackSymbol.push(oneSymbol);
            }
            else if (!(stackSymbol.empty()))
            {
                if (dictionaryPriority.get(stackSymbol.peek()) < dictionaryPriority.get(oneSymbol))
                {
                    stackSymbol.push(oneSymbol);
                }
                else
                {
                    while (!stackSymbol.empty() && dictionaryPriority.get(stackSymbol.peek()) >= dictionaryPriority.get(oneSymbol))
                    {
                        tempExpresion += stackSymbol.pop();
                    }
                    stackSymbol.push(oneSymbol);
                }
            }
        }

        while (!stackSymbol.empty())
        {
            tempExpresion += stackSymbol.pop();
        }

        System.out.println(tempExpresion);




        int resultCalculatePostfix = 0;
        Stack<Integer> stackCalc = new Stack<Integer>();

        for (int i = 0; i < tempExpresion.length(); i++)
        {
            char oneSymbol = tempExpresion.substring(i, i + 1).charAt(0);

            if ((int) oneSymbol >= 48 && (int) oneSymbol <= 57)
            {
                stackCalc.push((int) oneSymbol - 48);
            }
            else if ((oneSymbol == ')') || (oneSymbol == '(') || (oneSymbol == '+') || (oneSymbol == '-') || (oneSymbol == '*') || (oneSymbol == '/'))
            {
                switch (oneSymbol)
                {
                    case '+':
                        resultCalculatePostfix = stackCalc.pop() + stackCalc.pop();
                        stackCalc.push(resultCalculatePostfix);
                        break;
                    case '-':
                        resultCalculatePostfix = stackCalc.pop() - stackCalc.pop();
                        stackCalc.push(resultCalculatePostfix);
                        break;
                    case '*':
                        resultCalculatePostfix = stackCalc.pop() * stackCalc.pop();
                        stackCalc.push(resultCalculatePostfix);
                        break;
                    case '/':
                        resultCalculatePostfix = stackCalc.pop() / stackCalc.pop();
                        stackCalc.push(resultCalculatePostfix);
                        break;
                }
            }
        }

        return resultCalculatePostfix;
    }

    public static void main(String[] args)
    {
        System.out.println(Calculate("2+2"));
    }
}

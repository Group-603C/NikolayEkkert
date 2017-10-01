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

        Stack<String> stack_symbol = new Stack<String>();

        String tempExpresion = "";

        for (int i = 0; i < expresion.length(); i++)
        {
            String oneSymbol = expresion.substring(i, i + 1);
            if (oneSymbol.getBytes()[0] >= 48 && oneSymbol.getBytes()[0] <= 57)
            {
                tempExpresion += oneSymbol;
            }
            else if (stack_symbol.empty())
            {
                stack_symbol.push(oneSymbol);
            }
            else if (!(stack_symbol.empty()))
            {
                if (dictionaryPriority.get(stack_symbol.peek()) < dictionaryPriority.get(oneSymbol))
                {
                    stack_symbol.push(oneSymbol);
                }
                else
                {
                    while (!stack_symbol.empty() && dictionaryPriority.get(stack_symbol.peek()) >= dictionaryPriority.get(oneSymbol))
                    {
                        tempExpresion += stack_symbol.pop();
                    }
                    stack_symbol.push(oneSymbol);
                }
            }
        }

        while (!stack_symbol.empty())
        {
            tempExpresion += stack_symbol.pop();
        }

        System.out.println(tempExpresion);




        int resultCalculatePostfix = 0;
        Stack<Integer> stack_calc = new Stack<Integer>();

        for (int i = 0; i < tempExpresion.length(); i++)
        {
            char oneSymbol = tempExpresion.substring(i, i + 1).charAt(0);

            if ((int) oneSymbol >= 48 && (int) oneSymbol <= 57)
            {
                stack_calc.push((int) oneSymbol - 48);
            }
            else if ((oneSymbol == ')') || (oneSymbol == '(') || (oneSymbol == '+') || (oneSymbol == '-') || (oneSymbol == '*') || (oneSymbol == '/'))
            {
                switch (oneSymbol)
                {
                    case '+':
                        resultCalculatePostfix = stack_calc.pop() + stack_calc.pop();
                        stack_calc.push(resultCalculatePostfix);
                        break;
                    case '-':
                        resultCalculatePostfix = stack_calc.pop() - stack_calc.pop();
                        stack_calc.push(resultCalculatePostfix);
                        break;
                    case '*':
                        resultCalculatePostfix = stack_calc.pop() * stack_calc.pop();
                        stack_calc.push(resultCalculatePostfix);
                        break;
                    case '/':
                        resultCalculatePostfix = stack_calc.pop() / stack_calc.pop();
                        stack_calc.push(resultCalculatePostfix);
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

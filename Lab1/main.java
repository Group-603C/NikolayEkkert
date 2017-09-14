import com.sun.corba.se.impl.interceptors.SlotTableStack;

import java.io.PrintStream;

public class main
{
    public static void Fizzbuzz()
    {
        for (int i = 0; i <= 100; i++)
        {
            if (i % 15 == 0)
            {
                System.out.println("FIZZBUZZ");
            }
            else if (i % 5 == 0)
            {
                System.out.println("BUZZ");
            }
            else if (i % 3 == 0)
            {
                System.out.println("FIZZ");
            }
            else
            {
                System.out.println(i);
            }
        }
    }

    public static boolean IsSimple(int value)
    {
        for (int i = 2; i < value; i++)
        {
            if (value % i == 0)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean Parsing(String rowset)
    {
        int checkBracket = 0;
        for (int i = 0; i < rowset.length(); i++)
        {
            String oneSymbol = rowset.substring(i, i + 1);
            if (oneSymbol.equals("("))
            {
                checkBracket++;
            }
            else
            {
                checkBracket--;
            }

            if (checkBracket < 0)
            {
                return false;
            }

        }
        return checkBracket == 0;
    }

    public static void main(String[] args)
    {
        System.out.println(Parsing("(((") + "\n\n");

        System.out.println(IsSimple(13) + "\n\n");

        Fizzbuzz();
    }
}
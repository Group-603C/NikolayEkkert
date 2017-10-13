import java.util.ArrayList;
import java.util.List;

public class Formatter
{
    public String build(String formatString, Object... arguments)
    {
        StringBuilder editedFormatString = new StringBuilder(formatString);
        StringBuilder numberLabel = new StringBuilder();

        char[] arrayFormatString = formatString.toCharArray();
        boolean flag = false;
        int countOpenQuote = 0;
        int countCloseQuote = 0;

        int tempOpen = 0;
        int tempClose = 0;

        int counterArray = 0;

//        int[][] array = new int[arguments.length][];

//        ArrayQuotes indexArray = new ArrayQuotes();

        List<Integer> indexOpenQuote = new ArrayList<Integer>();
        List<Integer> indexCloseQuote = new ArrayList<Integer>();
        List<Integer> indexArgument = new ArrayList<Integer>();
        for (char element : arrayFormatString)
        {
            countOpenQuote++;
            countCloseQuote++;
            if (element == '{')
            {
                tempOpen = countOpenQuote;
                flag = true;
            }
            else if (element == '}')
            {
                tempClose = countCloseQuote;
                flag = false;
                String temp = numberLabel.toString();

                int numberArgument = Integer.parseInt(temp);
//                int[] tempArray = {tempOpen, tempClose, numberArgument};


                try
                {
                    indexOpenQuote.add(tempOpen);
                    indexCloseQuote.add(tempClose);
                    indexArgument.add(numberArgument);

//                    array[counterArray] = tempArray;
//                    counterArray++;
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                }
                numberLabel.delete(0, numberLabel.length());
            }
            else if (flag)
            {
                numberLabel.append(element);
            }
        }


        for (int i = arguments.length - 1; i >= 0; i--)
        {
            try
            {
//                editedFormatString.replace(array[i][0] - 1, array[i][1], arguments[array[i][2]].toString());
//                System.out.println(indexOpenQuote.get(i) - 1 + "\t" + indexCloseQuote.get(i) + "\t" + arguments[indexArgument.get(i)].toString());
                editedFormatString.replace(indexOpenQuote.get(i) - 1, indexCloseQuote.get(i), arguments[indexArgument.get(i)].toString());
            }
            catch (NullPointerException e)
            {
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
            }
            catch (IndexOutOfBoundsException e)
            {
            }
        }

        return editedFormatString.toString();
    }
}
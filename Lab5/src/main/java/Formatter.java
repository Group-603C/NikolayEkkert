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
                try
                {
                    int numberArgument = Integer.parseInt(temp);

                    indexOpenQuote.add(tempOpen);
                    indexCloseQuote.add(tempClose);
                    indexArgument.add(numberArgument);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                }
                catch (NumberFormatException e)
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
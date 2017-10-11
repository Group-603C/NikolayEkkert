import com.sun.deploy.util.StringUtils;

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

        int[][] array = new int[arguments.length][];

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
                int[] tempArray = {tempOpen, tempClose, numberArgument};

                array[counterArray] = tempArray;
                counterArray++;

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
                editedFormatString.replace(array[i][0] - 1, array[i][1], arguments[array[i][2]].toString());
            }
            catch (NullPointerException e)
            {
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Не корректная метка");
            }
        }

        return editedFormatString.toString();
    }
}
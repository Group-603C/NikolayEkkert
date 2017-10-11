import com.sun.deploy.util.StringUtils;

public class Formatter
{
    public String build(String formatString, Object... arguments)
    {
        for (int i = 0; i < arguments.length; i++)
        {
            formatString = formatString.replace("{" + i + "}", arguments[i].toString());
        }

        return formatString;
    }

    public String build1(String formatString, Object... arguments)
    {
        StringBuilder editedFormatString = new StringBuilder(formatString);
        StringBuilder numberLabel = new StringBuilder();

        char[] arrayFormatString = formatString.toCharArray();
        boolean flag = false;
        int countOpenQuote = 0;
        int countCloseQuote = 0;

        int tempOpen = 0;
        int tempClose = 0;

        for (char element : arrayFormatString)
        {
            countOpenQuote++;
            countCloseQuote++;
            if (element == '{')
            {
                tempOpen = countOpenQuote;
//                System.out.println("Open: " + countOpenQuote + "\t" + element);
//                System.out.println("2");
                flag = true;
            }
            else if (element == '}')
            {
                tempClose = countCloseQuote;
//                System.out.println("Close: " + countCloseQuote + "\t" + element);
//                System.out.println("3");
                flag = false;
//                System.out.println(numberLabel);

                String temp = numberLabel.toString();
                int numberArgument = Integer.parseInt(temp);
//                editedFormatString.replace(countOpenQuote, countCloseQuote, arguments[numberArgument].toString());

                System.out.println(tempOpen + "\t" + tempClose);
                editedFormatString.replace(tempOpen-1, tempClose, "!!");
//                editedFormatString.replace(tempOpen-1, tempClose, arguments[numberArgument].toString());

                numberLabel.delete(0, numberLabel.length());
            }
            else if (flag)
            {
//                System.out.println("1");
                numberLabel.append(element);
//                System.out.println(i);
//                System.out.println(numberLabel);
            }
        }

        return editedFormatString.toString();
    }
}
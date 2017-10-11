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
        StringBuilder temp = new StringBuilder(formatString);
        StringBuilder numberLabel = new StringBuilder();

        char[] arrayFormatString = formatString.toCharArray();
        boolean flag = false;

        for (char element : arrayFormatString)
        {
            if (element == '{')
            {
//                System.out.println("2");
                flag = true;
            }
            else if (element == '}')
            {
                System.out.println("3");
                flag = false;
                numberLabel.delete(0, numberLabel.length());
            }
            else if (flag)
            {
//                System.out.println("1");
                numberLabel.append(element);
//                System.out.println(numberLabel);
            }
        }

        return temp.toString();
    }
}
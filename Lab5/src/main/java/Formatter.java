public class Formatter
{
    public String build(String formatString, Object... arguments)
    {
        for (int i = 0; i < arguments.length; i++)
        {
            String argumentsElement = arguments[i].toString();
            formatString = formatString.replace("{" + i + "}", argumentsElement);
        }

        return formatString;
    }
}

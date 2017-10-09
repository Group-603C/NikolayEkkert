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
}

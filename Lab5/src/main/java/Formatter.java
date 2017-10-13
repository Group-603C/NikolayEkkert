import java.util.ArrayList;
import java.util.List;

public class Formatter {

    public String build(String formatString, Object... arguments) {

        char[] arrayFormatString = { };

        StringBuilder editedFormatString = new StringBuilder( );
        try {
            editedFormatString = new StringBuilder(formatString);
            arrayFormatString = formatString.toCharArray( );
        }
        catch (NullPointerException e) {
            
        }

        StringBuilder numberLabel = new StringBuilder( );

        boolean flag = false;

        int countOpenQuote = 0;
        int countCloseQuote = 0;

        int tempOpen = 0;
        int tempClose = 0;

        List<Integer> indexOpenQuote = new ArrayList<Integer>( );
        List<Integer> indexCloseQuote = new ArrayList<Integer>( );
        List<Integer> indexArgument = new ArrayList<Integer>( );

        for (char element : arrayFormatString) {

            countOpenQuote++;
            countCloseQuote++;

            if (element == '{') {
                tempOpen = countOpenQuote;
                flag = true;
            }
            else {

                if (element == '}') {
                    tempClose = countCloseQuote;
                    flag = false;
                    String temp = numberLabel.toString( );

                    try {
                        int numberArgument = Integer.parseInt(temp);

                        indexOpenQuote.add(tempOpen);
                        indexCloseQuote.add(tempClose);
                        indexArgument.add(numberArgument);
                    }
                    catch (ArrayIndexOutOfBoundsException e) {

                    }
                    catch (NumberFormatException e) {

                    }
                    numberLabel.delete(0, numberLabel.length( ));
                }

                else {
                    if (flag) {
                        numberLabel.append(element);
                    }
                }
            }
        }

        try {

            for (int i = arguments.length - 1; i >= 0; i--) {

                try {
                    editedFormatString.replace(indexOpenQuote.get(i) - 1, indexCloseQuote.get(i), arguments[indexArgument.get(i)].toString( ));
                }
                catch (NullPointerException e) {

                }
                catch (ArrayIndexOutOfBoundsException e) {

                }
                catch (IndexOutOfBoundsException e) {

                }
            }
        }
        catch (NullPointerException e) {

        }

        return editedFormatString.toString( );
    }
}
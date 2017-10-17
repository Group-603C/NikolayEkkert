public class Formatter {

    public String build(String formatString, Object... arguments) {

        StringBuilder editedFormatString = initEditedFormatString(formatString);

        Container[] arrayFormatString = createTemplateInsert(formatString, arguments);

        int counter = 0;
        try {

            counter = arguments.length - 1;
            for (Object argument : arguments) {
                if (arrayFormatString[counter] != null) {
                    arrayFormatString[counter].formationMessageRow(editedFormatString);
                }
                counter--;
            }
        }
        catch (NullPointerException e) {
        }

        return editedFormatString.toString( );
    }

    private StringBuilder initEditedFormatString(String formatString) {

        if (formatString != null) {
            StringBuilder editedFormatString = new StringBuilder(formatString);
            return editedFormatString;
        }
        StringBuilder editedFormatString = new StringBuilder( );

        return editedFormatString;
    }

    private Container[] createContainersRange(Object... arguments) {

        if (arguments != null) {
            Container[] array = new Container[arguments.length];
            return array;
        }

        return null;
    }

    private char[] initArrayFormatString(String formatString) {

        char[] arrayFormatString = { };
        try {
            arrayFormatString = formatString.toCharArray( );
        }
        catch (NullPointerException e) {
        }

        return arrayFormatString;
    }

    private Container[] createTemplateInsert(String formatString, Object... arguments) {

        char[] arrayFormatString = initArrayFormatString(formatString);

        boolean flag = false;
        int countOpenQuote = 0;
        int countCloseQuote = 0;
        int tempOpen = 0;
        int tempClose = 0;
        int counter = 0;

        Container[] array = createContainersRange(arguments);
        StringBuilder numberLabel = new StringBuilder( );

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
                        Container exemplar = new Container(tempOpen, tempClose, arguments[numberArgument].toString( ));
                        array[counter] = exemplar;
                        counter++;
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

        return array;
    }


    class Container {

        private int IndexOpenQuote;
        private int IndexCloseQuote;
        private String IndexArgument;

        Container(int open, int close, String text) {
            this.IndexOpenQuote = open;
            this.IndexCloseQuote = close;
            this.IndexArgument = text;
        }

        public String getIndexArgument( ) {
            return this.IndexArgument;
        }

        public int getIndexOpenQuote( ) {
            return this.IndexOpenQuote;
        }

        public int getIndexCloseQuote( ) {
            return this.IndexCloseQuote;
        }

        public void formationMessageRow(StringBuilder editedFormatString) {

            try {
                editedFormatString.replace(this.IndexOpenQuote - 1, this.IndexCloseQuote, this.IndexArgument);
            }
            catch (NullPointerException e) {
            }
        }
    }
}
public class Formatter {

    public String build(String formatString, Object... arguments) {

        StringBuilder editedFormatString = initEditedFormatString(formatString);

        Container[] arrayFormatString = createTemplateInsert(formatString, arguments);

        try {
            int counter = arguments.length - 1;
            for (Object argument : arguments) {
                arrayFormatString[0].formationMessageRow(editedFormatString, arrayFormatString[counter]);
                counter--;
            }
        }
        catch (NullPointerException e) {
        }

        return editedFormatString.toString( );
    }

    private StringBuilder initEditedFormatString(String formatString) {

        StringBuilder editedFormatString = new StringBuilder( );
        try {
            editedFormatString = new StringBuilder(formatString);
        }
        catch (NullPointerException e) {
        }

        return editedFormatString;
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

    private Container[] initArrayClassContainer(Object... arguments) {

        Container[] array = new Container[0];
        try {
            array = new Container[arguments.length];
        }
        catch (NullPointerException e) {
        }

        return array;
    }

    private Container[] createTemplateInsert(String formatString, Object... arguments) {

        char[] arrayFormatString = initArrayFormatString(formatString);

        boolean flag = false;
        int countOpenQuote = 0;
        int countCloseQuote = 0;
        int tempOpen = 0;
        int tempClose = 0;
        int counter = 0;

        Container[] array = initArrayClassContainer(arguments);
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

        public void formationMessageRow(StringBuilder editedFormatString, Container arrayFormatString) {

            try {
                editedFormatString.replace(arrayFormatString.getIndexOpenQuote( ) - 1, arrayFormatString.getIndexCloseQuote( ), arrayFormatString.getIndexArgument( ));
            }
            catch (Exception e) {
            }
        }
    }
}
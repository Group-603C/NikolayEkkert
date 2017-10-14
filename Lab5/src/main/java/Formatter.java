public class Formatter {

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
                        Container exemplar = new Container( );
                        exemplar.setIndexOpenQuote(tempOpen);
                        exemplar.setIndexCloseQuote(tempClose);
                        exemplar.setIndexArgument(arguments[numberArgument].toString( ));

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

    public String build(String formatString, Object... arguments) {

        StringBuilder editedFormatString = initEditedFormatString(formatString);

        Container[] arrayFormatString = createTemplateInsert(formatString, arguments);

        try {
            for (int i = arguments.length - 1; i >= 0; i--) {
                try {
                    editedFormatString.replace(arrayFormatString[i].getIndexOpenQuote( ) - 1, arrayFormatString[i].getIndexCloseQuote( ), arrayFormatString[i].getIndexArgument( ));
                }
                catch (Exception e) {
                }
            }
        }
        catch (NullPointerException e) {
        }

        return editedFormatString.toString( );
    }


    class Container {

        private int IndexOpenQuote;
        private int IndexCloseQuote;
        private String IndexArgument;

        public void setIndexArgument(String text) {
            this.IndexArgument = text;
        }

        public void setIndexOpenQuote(int index) {
            this.IndexOpenQuote = index;
        }

        public void setIndexCloseQuote(int index) {
            this.IndexCloseQuote = index;
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
    }
}
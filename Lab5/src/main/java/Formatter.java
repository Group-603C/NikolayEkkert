public class Formatter {

    public String build(String formatString, Object... arguments) {

        if (formatString == null) {
            return "";
        }

        StringBuilder editedFormatString = new StringBuilder(formatString);

        Container[] tempFormatString = createTemplateInsert(formatString, arguments);

        int counter = 0;
        counter = arguments.length - 1;
        for (Object argument : arguments) {
            if (tempFormatString[counter] != null) {
                tempFormatString[counter].formationMessageRow(editedFormatString);
            }
            counter--;
        }

        return editedFormatString.toString( );
    }

    private Container[] createTemplateInsert(String formatString, Object... arguments) {

        char[] tempFormatString = formatString.toCharArray( );

        boolean flag = false;
        int countOpenQuote = 0;
        int countCloseQuote = 0;
        int tempOpen = 0;
        int tempClose = 0;
        int counter = 0;

        Container[] instance = new Container[arguments.length];
        StringBuilder numberLabel = new StringBuilder( );

        for (char element : tempFormatString) {

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
                        instance[counter] = exemplar;
                        counter++;
                    }
                    catch (Exception e) {
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

        return instance;
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
public class Formatter {

    public String build(String formatString, Object... arguments) {

        if (formatString == null) {
            return "";
        }

        StringBuilder editedFormatString = new StringBuilder(formatString);

        Container[] tempFormatString = createTemplateInsert(formatString, arguments);

        for (Container element : tempFormatString) {
            if (element != null) {
                element.formationMessageRow(editedFormatString);
            }
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
        int counter = arguments.length - 1;

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
                        counter--;
                    }
                    catch (IndexOutOfBoundsException e) {
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

        return instance;
    }


    class Container {

        private int indexOpenQuote;
        private int indexCloseQuote;
        private String indexArgument;

        Container(int open, int close, String text) {
            this.indexOpenQuote = open;
            this.indexCloseQuote = close;
            this.indexArgument = text;
        }

        public String getIndexArgument( ) {
            return this.indexArgument;
        }

        public int getIndexOpenQuote( ) {
            return this.indexOpenQuote;
        }

        public int getIndexCloseQuote( ) {
            return this.indexCloseQuote;
        }

        public void formationMessageRow(StringBuilder editedFormatString) {

            try {
                editedFormatString.replace(this.indexOpenQuote - 1, this.indexCloseQuote, this.indexArgument);
            }
            catch (NullPointerException e) {
            }
        }
    }
}
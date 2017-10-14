import java.util.ArrayList;
import java.util.List;

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

        //        List<Integer> indexOpenQuote = new ArrayList<Integer>( );
        //        List<Integer> indexCloseQuote = new ArrayList<Integer>( );
        //        List<Integer> indexArgument = new ArrayList<Integer>( );

//        int[] array = new int[arguments.length];
        int counter = 0;

        Container[] array = new Container[0];
        try {
            array = new Container[arguments.length];
        }
        catch (NullPointerException e) {

        }
//        Container[] exemplar = new Container[arguments.length];
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


//                        System.out.println(counter);
                        array[counter] = exemplar;
//                        System.out.println(array[counter].getIndexOpenQuote());
                        counter++;
//                        System.out.println("rrr\t" + array[counter].getIndexOpenQuote());
//                        System.out.println("fff\t" + array[counter]);

//                        array[i] = exemplar.setIndexOpenQuote(tempOpen);
//                        exemplar[counter].setIndexCloseQuote(tempClose);
//                        exemplar[counter].setIndexOpenQuote(tempOpen);
//                        exemplar[counter].setIndexArgument(arguments[numberArgument].toString( ));
//                        System.out.println(exemplar[counter].getIndexOpenQuote( ));

                        //                        indexOpenQuote.add(tempOpen);
                        //                        indexCloseQuote.add(tempClose);
                        //                        indexArgument.add(numberArgument);

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

//        System.out.println("fdfdf\t" + array[0]);

        try {


            for (int i = arguments.length - 1; i >= 0; i--) {
//                System.out.println("1");
//                System.out.println(array[i].getIndexOpenQuote( ) + "\t" + array[i].getIndexCloseQuote( ) + "\t" + array[i].getIndexArgument( ));
                try {
//editedFormatString.replace(indexOpenQuote.get(i) - 1, indexCloseQuote.get(i), arguments[indexArgument.get(i)].toString( ));
                    editedFormatString.replace(array[i].getIndexOpenQuote( ) - 1, array[i].getIndexCloseQuote( ), array[i].getIndexArgument( ));
                }
                catch (Exception e) {

                }
            }
        }
        catch (NullPointerException e) {

        }

//        System.out.println(editedFormatString);
        return editedFormatString.toString( );
    }
}
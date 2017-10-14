public class Main {

    public static void main(String[] args) {

        Formatter exemplar = new Formatter( );
        String text = exemplar.build("здесь {0}, а здесь {1}, а вот {2}", "мама", "папа");

        System.out.println(text);

//        Container[] array = new Container[3];
//        for (int i = 0; i < 3; i++) {
//            Container exem = new Container( );
//            exem.setIndexArgument(Integer.toString(-10));
//            exem.setIndexOpenQuote(i + 15);
//            exem.setIndexCloseQuote(i - 170);
//            array[i] = exem;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            System.out.println(array[i].getIndexOpenQuote( ) + "\t" + array[i].getIndexArgument( ) + "\t" + array[i].getIndexCloseQuote( ));
//        }
//
//        Container[] array = new Container[3];
//
//        Container exem = new Container( );
//        exem.setIndexOpenQuote(111);
//        exem.setIndexCloseQuote(1222);
//        exem.setIndexArgument("ZZZZ");
//        array[0] = exem;
//
//        exem.setIndexOpenQuote(2222);
//        exem.setIndexCloseQuote(2222);
//        exem.setIndexArgument("VVVV");
//        array[1] = exem;
//
//        exem.setIndexOpenQuote(6666);
//        exem.setIndexCloseQuote(224343422);
//        exem.setIndexArgument("FFFF");
//        array[2] = exem;
//
//        System.out.println(array[0]);
//        System.out.println(array[1]);
//        System.out.println(array[2]);


//        exem[0].setIndexArgument("111");
//        exem[1].setIndexCloseQuote(1);
//        exem[1].setIndexArgument("222");
//        exem[2].setIndexArgument("333");
//        System.out.println(exem[1].getIndexArgument());
    }
}
public class Main {

    public static void main(String[] args) {

        Formatter exemplar = new Formatter( );
        String text = exemplar.build("Нельзя {2} так взять и {3} {0} по {1}", "лабы", "Java", "так", "сдать", "иначе кирдык");

        System.out.println(text);
    }
}
public class Main
{
    public static void main(String[] args)
    {
        Formatter exemplar = new Formatter();
        String text = exemplar.build("здесь {0}, а здесь {1}, а вот {2}", "мама", "папа");

        System.out.println(text);
    }
}
public class Main
{
    public static void main(String[] args)
    {
        Formatter exemplar = new Formatter();
        String text = exemplar.build1("здесь {0}, а здесь {1}, а вот {2}", "мама", "папа", "Я");

        System.out.println(text);
    }
}
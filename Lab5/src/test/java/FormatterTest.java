import static org.junit.Assert.*;

public class FormatterTest
{
    @org.junit.Test
    public void build() throws Exception
    {
        Formatter exemplar = new Formatter();

        String value = exemplar.build("здесь {0}, а здесь {1}, а вот {2}", "мама", "папа", "Я");
        String expected = "здесь мама, а здесь папа, а вот Я";
        assertEquals("One test", expected, value);

        value = exemplar.build("Вот и наступил {3} год, пора мне пройти {1} страны, посетить {0} музея и пролететь {2} км", 32, 196, 22, 777);
        expected = "Вот и наступил 777 год, пора мне пройти 196 страны, посетить 32 музея и пролететь 22 км";
        assertEquals("Two test", expected, value);

        value = exemplar.build("Нельзя {2} так взять и {3} {0} по {1}", "лабы", "Java", "так", "сдать", "иначе кирдык");
        expected = "Нельзя так так взять и сдать лабы по Java";
        assertEquals("Three test", expected, value);

        value = exemplar.build("здесь {0}, а здесь {1}, а вот {2}", "мама", "папа");
        expected = "здесь мама, а здесь папа, а вот {2}";
        assertEquals("Four test", expected, value);
    }

}
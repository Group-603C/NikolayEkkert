import org.junit.experimental.theories.FromDataPoints;

import static org.junit.Assert.*;

public class FormatterTest {

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

    @org.junit.Test
    public void build( ) throws Exception {

        Formatter exemplar = new Formatter( );

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

        value = exemplar.build("здесь {0, а здесь {1}, а вот {2}", "мама", "папа");
        expected = "здесь {0, а здесь {1}, а вот {2}";
        assertEquals("Five test", expected, value);

        value = exemplar.build("", "мама", "папа");
        expected = "";
        assertEquals("Six test", expected, value);

        value = exemplar.build("здесь 0, а здесь {1}, а вот {2}", "мама", "папа");
        expected = "здесь 0, а здесь папа, а вот {2}";
        assertEquals("Seven test", expected, value);

        value = exemplar.build("", "");
        expected = "";
        assertEquals("Eight test", expected, value);

        value = exemplar.build(null, null);
        expected = "";
        assertEquals("Nine test", expected, value);

        value = exemplar.build("Здесь int значение {0}", 20543);
        expected = "Здесь int значение 20543";
        assertEquals("Ten test", expected, value);

        value = exemplar.build("Здесь float значение {0}", 0.68f);
        expected = "Здесь float значение 0.68";
        assertEquals("Eleven test", expected, value);

        value = exemplar.build("Здесь double значение {0}", 3.14d);
        expected = "Здесь double значение 3.14";
        assertEquals("Twelve test", expected, value);

        value = exemplar.build("Здесь char значение {0}", 'V');
        expected = "Здесь char значение V";
        assertEquals("Thirteen test", expected, value);

        Object objZero = "Object";
        value = exemplar.build("Здесь object значение {0}", objZero);
        expected = "Здесь object значение Object";
        assertEquals("Fourteen test", expected, value);

        Object objOne = 1234.54;
        value = exemplar.build("Здесь object значение {0}", objOne);
        expected = "Здесь object значение 1234.54";
        assertEquals("Fifteen test", expected, value);

        value = exemplar.build("Здесь boolean значение {0}", true);
        expected = "Здесь boolean значение true";
        assertEquals("Sixteen test", expected, value);

        String text = "text";
        value = exemplar.build("Здесь String значение {0}", text);
        expected = "Здесь String значение text";
        assertEquals("Seventeen test", expected, value);

        value = exemplar.build("Без параметров");
        expected = "Без параметров";
        assertEquals("Eighteen test", expected, value);

        Container customType = new Container(1, 2, "e");
        value = exemplar.build("Собственный тип {0}", customType);
        expected = "Собственный тип ";
        assertEquals("Nineteen test", expected, value);
    }
}
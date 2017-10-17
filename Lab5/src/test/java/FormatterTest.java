import org.junit.experimental.theories.FromDataPoints;

import static org.junit.Assert.*;

public class FormatterTest {

    class Box {
        int width;
        int height;
        int depth;

        Box(int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        @Override
        public String toString( ) {
            return "Размер " + width + " * " + height + " * " + depth;
        }
    }

    @org.junit.Test
    public void build( ) throws Exception {

        Formatter exemplar = new Formatter( );

        String value = exemplar.build("здесь {0}, а здесь {1}, а вот {2}", "мама", "папа", "Я");
        String expected = "здесь мама, а здесь папа, а вот Я";
        assertEquals("Корректный ввод и передача", expected, value);

        value = exemplar.build("Вот и наступил {3} год, пора мне пройти {1} страны, посетить {0} музея и пролететь {2} км", 32, 196, 22, 777);
        expected = "Вот и наступил 777 год, пора мне пройти 196 страны, посетить 32 музея и пролететь 22 км";
        assertEquals("Не последовательная расстановка меток в шаблоне", expected, value);

        value = exemplar.build("Нельзя {2} так взять и {3} {0} по {1}", "лабы", "Java", "так", "сдать", "иначе кирдык");
        expected = "Нельзя так так взять и сдать лабы по Java";
        assertEquals("Параметров больше, чем меток", expected, value);

        value = exemplar.build("здесь {0}, а здесь {1}, а вот {2}", "мама", "папа");
        expected = "здесь мама, а здесь папа, а вот {2}";
        assertEquals("Параметров меньше, чем меток", expected, value);

        value = exemplar.build("здесь {0, а здесь {1}, а вот {2}", "мама", "папа");
        expected = "здесь {0, а здесь {1}, а вот {2}";
        assertEquals("Не закрытая метка", expected, value);

        value = exemplar.build("", "мама", "папа");
        expected = "";
        assertEquals("Six test", expected, value);

        value = exemplar.build("здесь 0, а здесь {1}, а вот {2}", "мама", "папа");
        expected = "здесь 0, а здесь папа, а вот {2}";
        assertEquals("Вместо метки 0, цифра 0", expected, value);

        value = exemplar.build("", "");
        expected = "";
        assertEquals("Передача пустого шаблона", expected, value);

        value = exemplar.build(null, null);
        expected = "";
        assertEquals("Шаблон и аргумент null", expected, value);

        value = exemplar.build("Здесь int значение {0}", 20543);
        expected = "Здесь int значение 20543";
        assertEquals("Параметр типа int", expected, value);

        value = exemplar.build("Здесь float значение {0}", 0.68f);
        expected = "Здесь float значение 0.68";
        assertEquals("Параметр типа float", expected, value);

        value = exemplar.build("Здесь double значение {0}", 3.14d);
        expected = "Здесь double значение 3.14";
        assertEquals("Параметр типа double", expected, value);

        value = exemplar.build("Здесь char значение {0}", 'V');
        expected = "Здесь char значение V";
        assertEquals("Параметр типа char", expected, value);

        Object objZero = "Object";
        value = exemplar.build("Здесь object значение {0}", objZero);
        expected = "Здесь object значение Object";
        assertEquals("Параметр типа Object с числом", expected, value);

        Object objOne = 1234.54;
        value = exemplar.build("Здесь object значение {0}", objOne);
        expected = "Здесь object значение 1234.54";
        assertEquals("Параметр типа Object со строкой", expected, value);

        value = exemplar.build("Здесь boolean значение {0}", true);
        expected = "Здесь boolean значение true";
        assertEquals("Параметр типа boolean", expected, value);

        String text = "text";
        value = exemplar.build("Здесь String значение {0}", text);
        expected = "Здесь String значение text";
        assertEquals("Параметр типа String", expected, value);

        value = exemplar.build("Без параметров");
        expected = "Без параметров";
        assertEquals("Отсутствие параметра", expected, value);

        Box box = new Box(111,222,333);
        value = exemplar.build("Параметр класс: {0}", box);
        expected = "Параметр класс: Размер 111 * 222 * 333";
        assertEquals("Передача класса с тремя полями и перегрузка toString", expected, value);
    }
}
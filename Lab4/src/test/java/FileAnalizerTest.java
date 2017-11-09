import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FileAnalizerTest {

    private FileAnalizer customAnalizer = new FileAnalizer("text2.txt");

    @org.junit.Test
    public void countLetters() throws Exception {

        int actual = customAnalizer.countLetters();
        int expect = 25;
        assertEquals(actual, expect);
    }

    @org.junit.Test
    public void countWords() throws Exception {

        int actual = customAnalizer.countWords();
        int expect = 7;
        assertEquals(actual, expect);
    }

    @org.junit.Test
    public void countLines() throws Exception {

        int actual = customAnalizer.countLines();
        int expect = 5;
        assertEquals(actual, expect);
    }

    @org.junit.Test
    public void countFrequencyCharacteristic() throws Exception {

        Map<Character, Integer> expect = new HashMap<Character, Integer>();
        expect.put('р', 1);
        expect.put(' ', 9);
        expect.put('b', 1);
        expect.put('d', 2);
        expect.put('f', 3);
        expect.put('g', 5);
        expect.put('\n', 4);
        expect.put(',', 1);
        expect.put('\r', 4);
        expect.put('.', 4);
        expect.put('а', 1);
        expect.put('Б', 1);
        expect.put('r', 2);
        expect.put('s', 1);
        expect.put('v', 2);
        expect.put('w', 3);
        expect.put('\\', 1);
        expect.put('|', 1);
        expect.put('н', 2);
        expect.put('о', 1);

        Map actual = customAnalizer.countFrequencyCharacteristic();

        assertEquals(actual, expect);
    }
}
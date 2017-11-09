import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FileAnalizer {

    private String content;


    public FileAnalizer(String path) {

//        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//            stream.forEach(System.out::println);
//        }

//        try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
//            lines.forEachOrdered(System.out::println);
//        }

        try (Stream<String> lines = Files.lines (Paths.get(path), StandardCharsets.UTF_8))
        {
            for (String line : (Iterable<String>) lines::iterator)
            {
                System.out.println(line);
            }
        }
        catch (IOException e){

        }
//
//        try (Stream<String> str = Files.lines(Paths.get(path))) {
//            str.forEach(System.out::println);
//        }
//        catch (IOException e) {
//
//        }

//        try {
//
//            content = new String(Files.lines(Paths.get(path)));
//            System.out.println(content);
//
//        }
//        catch (IOException e) {
//
//            throw new IllegalArgumentException("File not found!");
//        }
    }


    public int countLetters() {

        return content.replaceAll("[^a-zA-Zа-яА-Я]", "")
                      .length();
    }

    public int countWords() {

        return content.replaceAll("([^A-Za-zА-Яа-я])([\\s\\W]+)", " ")
                      .split(" ").length;
    }

    public int countLines() {

        return content.split("\n").length;
    }

    public Map<Character, Integer> countFrequencyCharacteristic() {

        Map<Character, Integer> countSymbol = new HashMap<Character, Integer>();

        char[] formatContent = content.toCharArray();
        for (char element : formatContent) {

            if (countSymbol.get(element) != null) {

                countSymbol.put(element, countSymbol.get(element) + 1);
            }
            else {

                countSymbol.put(element, 1);
            }
        }

        return countSymbol;
    }
}
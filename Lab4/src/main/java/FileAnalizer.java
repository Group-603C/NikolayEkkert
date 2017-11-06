import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileAnalizer {

    private String content;


    public FileAnalizer(String path) {

        try {

            content = new String(Files.readAllBytes(Paths.get(path)));

        }
        catch (IOException e) {

            throw new IllegalArgumentException("File not found!");
        }
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